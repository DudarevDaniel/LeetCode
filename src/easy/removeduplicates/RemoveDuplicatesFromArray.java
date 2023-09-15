package easy.removeduplicates;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/?envType=study-plan-v2&envId=top-interview-150">LeetCode</a>
 */
public class RemoveDuplicatesFromArray {

    public static void main(String[] args) {
        RemoveDuplicatesFromArray main = new RemoveDuplicatesFromArray();
//        int[] nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
//        int[] nums = new int[]{1, 1, 2};
        int[] nums = new int[]{1, 1, 1};
//        int[] nums = new int[]{1, 1, 2, 3};
        int unique = main.removeDuplicates(nums);
        System.out.println(unique);
        System.out.println(Arrays.toString(nums));
    }

    public int removeDuplicates(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }
        int count = 1;
        int uniqueIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            int previous = nums[uniqueIndex];
            int current = nums[i];
            if (previous == current) {
                while (i < nums.length && nums[i] == current) {
                    i++;
                }
                if (uniqueIndex < nums.length - 1 && i < nums.length) {
                    swap(nums, uniqueIndex + 1, i);
                    count++;
                    uniqueIndex++;
                }
            } else {
                count++;
                uniqueIndex++;
                if (uniqueIndex < i) {
                    swap(nums, uniqueIndex, i);
                }
            }
        }
        return count;
    }

    private void swap(int[] nums, int from, int to) {
        int temp = nums[from];
        nums[from] = nums[to];
        nums[to] = temp;
    }
}
