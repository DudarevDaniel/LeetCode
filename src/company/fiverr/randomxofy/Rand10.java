package company.fiverr.randomxofy;

import java.util.Random;

/**
 * https://leetcode.com/problems/implement-rand10-using-rand7/solutions/338395/in-depth-straightforward-detailed-explanation-short-java-solution/
 */
public class Rand10 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.rand10());
    }

    public static class SolBase {
        public int rand7() {
            return new Random().nextInt(7) + 1;
        }
    }

    public static class Solution extends SolBase {
        public int rand10() {
            int rand40 = Integer.MAX_VALUE;
            while (rand40 >= 40) {
                // rand42 + rand6 = rand48, so it's rand48
                rand40 = (rand7() - 1) * 7 + (rand7() - 1);
            }
            // random10 = random40 % 10 + 1
            return rand40 % 10 + 1;
        }
    }
}
