package company.fiverr.shufflearray;

import java.util.Arrays;
import java.util.Random;

/**
 * https://leetcode.com/problems/shuffle-an-array/
 */
public class ShuffleArray {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        ShuffleArray main = new ShuffleArray();
        Solution solution = new Solution(nums);
        System.out.println(Arrays.toString(solution.shuffle()));
        System.out.println(Arrays.toString(solution.reset()));
    }

    public static class Solution {

        private int[] original;

        public Solution(int[] nums) {
            this.original = nums;
        }

        public int[] reset() {
            return original;
        }

        public int[] shuffle() {
            int[] mutated = new int[original.length];
            System.arraycopy(original, 0, mutated, 0, original.length);
            Random random = new Random();
            for (int i = mutated.length; i > 0; i--) {
                int index = random.nextInt(i);
                swap(i - 1, index, mutated);
            }
            return mutated;
        }

        private void swap(int index1, int index2, int[] arr) {
            int temp = arr[index1];
            arr[index1] = arr[index2];
            arr[index2] = temp;
        }
    }
}
