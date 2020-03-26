package chap10;

import java.util.Random;

public class Game {
    private int[] nums;

    public Game(int[] nums) {
        this.nums = nums;
        /*
        Random random = new Random();
        int firstNo = random.nextInt(10);
        int secondNo = random.nextInt(10);
        int thirdNo = random.nextInt(10);
        this.nums = new int[] {firstNo, secondNo, thirdNo };
         */
    }
    public Game(GameNumGen gen) {
        this.nums = gen.generate();
    }

    public int[] getNums() {
        return nums;
    }

    public Score guess(int first, int second, int third) {
        int one = nums[0];
        int two = nums[1];
        int tree = nums[2];

        int[] guess = {first, second, third};

        int strikes = 0;
        int balls = 0;
        int outs = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j=0; j<guess.length; j++) {
                if (i == j) {
                    if (nums[i] == guess[j]) {
                        strikes++;
                    }
                }
                if (i < j) {
                    if (nums[i] == guess[j]) {
                        balls++;
                    }
                }
                if (i > j) {
                    if (nums[i] == guess[j]) {
                        balls++;
                    }
                }
            }
        }
        return new Score(strikes, balls);
    }
}
