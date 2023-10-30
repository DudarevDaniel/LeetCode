package company.fiverr.rotatearray;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/rotate-array/">LeetCode</a>
 */
public class RotateArray {

    public static void main(String[] args) {
        RotateArray main = new RotateArray();
//        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
//        int[] nums = new int[]{-1, -100, 3, 99};
//        int[] nums = new int[]{1, 2};
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27};
//        int k = 3;
//        int k = 2;
//        int k = 1;
        int k = 38;
        main.rotate(nums, k);
        System.out.println(Arrays.toString(nums));
    }

    public void rotate(int[] nums, int k) {
        k %= nums.length;
        int n = nums.length;
        reverseNum(nums, 0, n - 1);
        reverseNum(nums, 0, k - 1);
        reverseNum(nums, k, n - 1);
    }

    public void reverseNum(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

}
