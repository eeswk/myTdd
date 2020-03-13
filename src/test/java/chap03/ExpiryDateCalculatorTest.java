package chap03;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExpiryDateCalculatorTest {
    /**
     * - 서비스를 사용하려면 매달 1만원 선불로 납부한다. 납부일 기준으로 한달 뒤가 서비스 만료일이 된다.
     * - 2개월 이상 요금을 납부할수 있다.
     * - 10만원을 납부하면 서비스를 1년 제공한다.*
     */

    /**
     * 납부한 금액 기준으로 서비스 만료일을 걔산하는 기능 TDD
     * 1.구현하기 쉬운것 부터 먼저 테스트
     * 2.예외 상황을 먼저 테스트
     */

    /**
     * 필요한 값: 납부일과 납부액
     * 결과: 만료일
     */

    @Test
    void 만원_납부하면_한달_뒤가_만료일이_됨() {
        /* 중복제거 메서드 추출
        LocalDate billingDate = LocalDate.of(2020, 03, 12);
        int payAmount = 10_000;

        ExpiryDateCalculator cal = new ExpiryDateCalculator();
        LocalDate expireDate = cal.calculateExpireDate(billingDate, payAmount);
        assertEquals(LocalDate.of(2020, 04, 12), expireDate);

        LocalDate billingDate2 = LocalDate.of(2020, 03, 01);
        int payAmount2 = 10_000;
        ExpiryDateCalculator cal2 = new ExpiryDateCalculator();
        LocalDate expireDate2 = cal2.calculateExpireDate(billingDate2, payAmount2);
        assertEquals(LocalDate.of(2020, 04, 01), expireDate2);
        */

        /* payData로 변경
        assertExpireDate(
                LocalDate.of(2020, 03, 12),
                10_000,
                LocalDate.of(2020, 04, 12)
        );


        assertExpireDate(
                LocalDate.of(2020, 04, 01),
                10_000,
                LocalDate.of(2020, 05, 01)
        );
        */
        assertExpireDate(
                PayData.builder()
                        .billingDate(LocalDate.of(2020,03,12))
                        .payAmount(10000)
                        .build(),
                LocalDate.of(2020, 04, 12));
        assertExpireDate(
                PayData.builder()
                        .billingDate(LocalDate.of(2020,04,01))
                        .payAmount(10000)
                        .build(),
                LocalDate.of(2020, 05, 01));
    }

    @Test
    void 납부일과_한달_뒤_일자가_같지_않음() {
        //예외 상황을 먼저 테스트
        /**
         * 납부일이 2020-01-31이고 납부액이 1만원이면 만료일은 2020-02-29
         * 납부일이 2020-05-31이고 납부액이 1만원이면 만료일은 2020-06-30
         */
        /* payData로 변경
        assertExpireDate(
                LocalDate.of(2020,01,31),
                10000,
                LocalDate.of(2020, 02, 29));
        assertExpireDate(
                LocalDate.of(2020,05,31),
                10000,
                LocalDate.of(2020, 06, 30));

         */
        /**
         * 2만월을 지불하면 만료일이 2달뒤가 된다.
         * 3만원을 지불하면 만료일이 3달뒤가 된다.
         * 첫 납부일이 2020-01-31이고 만료되는 2020-02-29에 1만월 납부하면 다음 만료일은 2020-03-31 이다.
         * 첫 납부일이 2020-05-31이고 만료되는 2020-06-30에 1만월 납부하면 다음 만료일은 2020-07-31 이다.
         */
        // 첫 납부일이 필요하다. 기존코드에 첫 납부일을 추가하는 작업이 필요하다.
        // calculateExpireDate 메서드에 파라미터로 첫 납부일을 추가
        // 첫납부일, 납부일, 납부액을 담을 객체를 calculateExpireDate 메서드에 전달.
        // 파라미터가 3개로 늘어난다. 적을수록 가독성과 유지보수에 유리하므로 객체로 바꿔 한개로 줄이는 것을 고려.
        // PayData class 생성
        // calculateExpireDate() 새로운 메서드 생성
        // 기존 calculateExpireDate 메서드를 신규 calculateExpireDate 메서드를 호출하도록 변경
        // 새로 만든 calculateExpireDate를 사용하는 assertExpireDate 메서드를 테스트 클래스에 새로 추가
        // 기존 assertExpireDate 메서드를 인라인 처리하여 각 테스트 코드가 새로만든 assertExpireDate 메서드를 호출하도록 변경
        // 기존 calculateExpireDate 메서드 삭제

        assertExpireDate(
                PayData.builder()
                        .billingDate(LocalDate.of(2020,01,31))
                        .payAmount(10000)
                        .build(),
                LocalDate.of(2020, 02, 29));

        assertExpireDate(
                PayData.builder()
                        .billingDate(LocalDate.of(2020,05,31))
                        .payAmount(10000)
                        .build(),
                LocalDate.of(2020, 06, 30));
    }

    /*
    private void assertExpireDate(LocalDate billingDate, int payAmount, LocalDate expectedExpireDate) {
        ExpiryDateCalculator cal = new ExpiryDateCalculator();
        LocalDate expireDate = cal.calculateExpireDate(billingDate, payAmount);
        assertEquals(expectedExpireDate, expireDate);

    }
    */

    @Test
    void 첫_납부일과_만료일_일자가_다를때_만원_납부() {
        PayData payData = PayData.builder()
                .firstBillingDate(LocalDate.of(2020, 01, 31))
                .billingDate(LocalDate.of(2020,02, 29))
                .payAmount(10000)
                .build();
        assertExpireDate(payData, LocalDate.of(2020, 03, 31));

        PayData payData2 = PayData.builder()
                .firstBillingDate(LocalDate.of(2020, 01, 30))
                .billingDate(LocalDate.of(2020,02, 29))
                .payAmount(10000)
                .build();
        assertExpireDate(payData2, LocalDate.of(2020, 03, 30));

        PayData payData3 = PayData.builder()
                .firstBillingDate(LocalDate.of(2020, 5, 31))
                .billingDate(LocalDate.of(2020,6, 30))
                .payAmount(10000)
                .build();
        assertExpireDate(payData3, LocalDate.of(2020, 7, 31));
    }

    @Test
    void 이만원_이상_납부하면_비례해서_만료일_계산() {

        PayData payData1 = PayData.builder()
                .billingDate(LocalDate.of(2020,6, 01))
                .payAmount(20000)
                .build();
        assertExpireDate(payData1, LocalDate.of(2020, 8, 01));

        PayData payData2 = PayData.builder()
                .billingDate(LocalDate.of(2020,6, 01))
                .payAmount(30000)
                .build();
        assertExpireDate(payData2, LocalDate.of(2020, 9, 01));
    }

    @Test
    void 첫_납부일과_만료일_일자가_다를때_이만원_이상_납부() {
        PayData payData1 = PayData.builder()
                .firstBillingDate(LocalDate.of(2020, 01, 31))
                .billingDate(LocalDate.of(2020,02, 29))
                .payAmount(20000)
                .build();
        assertExpireDate(payData1, LocalDate.of(2020, 04, 30));

        /*
        PayData payData2 = PayData.builder()
                .firstBillingDate(LocalDate.of(2020, 02, 29))
                .billingDate(LocalDate.of(2020,03, 31))
                .payAmount(20000)
                .build();
        assertExpireDate(payData2, LocalDate.of(2020, 05, 31));
         */
    }


    private void assertExpireDate(PayData payData, LocalDate expectedExpireDate) {
        ExpiryDateCalculator cal = new ExpiryDateCalculator();
        LocalDate expireDate = cal.calculateExpireDate(payData);
        assertEquals(expectedExpireDate, expireDate);

    }


}
