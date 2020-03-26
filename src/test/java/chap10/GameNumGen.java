package chap10;

import java.util.Random;

public class GameNumGen {
    public int[] generate() {
        //랜덤하게 생성
        Random random = new Random();
        int firstNo = random.nextInt(10);
        int secondNo = random.nextInt(10);
        int thirdNo = random.nextInt(10);
        return new int[] {firstNo, secondNo, thirdNo };
    }
}
