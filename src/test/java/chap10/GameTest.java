package chap10;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class GameTest {

    @Test
    void noMatch() {
        /*
        int[] nums = {1, 2, 3};
        Game game = new Game(nums);
        System.out.println(game.getNums()[0] +"," + game.getNums()[1] + "," +game.getNums()[2] );
        */

        //랜덤 값 생성을 별도 타입으로 분리하고
        //이를 대역으로 대체해서 대체
        GameNumGen gen = mock(GameNumGen.class);
        given(gen.generate()).willReturn(new int[] {1, 2, 3});

        Game g = new Game(gen);
        Score s = g.guess(4, 5, 6);
        assertEquals(0, s.strike());
        assertEquals(0, s.balls());

        //Score score = game.guess(?, ?, ?); //테스트를 통과시킬시 있는 값이 매번 바뀜
        //assertEquals(0, score.strike());
        //assertEquals(0, score.balls());
    }

}