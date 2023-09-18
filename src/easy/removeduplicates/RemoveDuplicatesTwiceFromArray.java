package easy.removeduplicates;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class RemoveDuplicatesTwiceFromArray {

    public static void main(String[] args) {
        RemoveDuplicatesTwiceFromArray main = new RemoveDuplicatesTwiceFromArray();
//        int[] nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
//        int[] nums = new int[]{0, 0, 1, 1, 1, 1, 2, 3};
        int[] nums = new int[]{1, 1, 1, 2, 2, 2, 3, 3};
//        int[] nums = new int[]{0, 0, 1, 1, 1, 1};
//        int[] nums = new int[]{1, 1, 2};
//        int[] nums = new int[]{1, 1, 1};
//        int[] nums = new int[]{1, 1, 1, 2, 2, 3};
//        int[] nums = new int[]{1, 1, 2, 3};
        int unique = main.removeDuplicates(nums);
        System.out.println(unique);
        System.out.println(Arrays.toString(nums));
    }

    public int removeDuplicates(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }
        int uniqueIndex = 0;
        int currentDuplicateCount = 1;
        for (int i = 1; i < nums.length; i++) {
            int previous = nums[uniqueIndex];
            int current = nums[i];
            if (previous == current) {
                currentDuplicateCount++;
                if (currentDuplicateCount > 2) {
                    int j = i + 1;
                    while (j < nums.length && nums[j] <= current) {
                        j++;
                    }
                    if (j < nums.length) {
                        swap(nums, i, j);
                        currentDuplicateCount = 1;
                    } else {
                        uniqueIndex--;
                    }
                }
                uniqueIndex++;
            } else if (previous > current) {
                if (i < (nums.length - 1)) {
                    int j = i + 1;
                    while (j < nums.length && nums[j] <= current) {
                        j++;
                    }
                    if (j < nums.length) {
                        swap(nums, i, j);
                        i--;
                    }
                }
            } else {
                uniqueIndex++;
                currentDuplicateCount = 1;
            }
        }
        return uniqueIndex + 1;
    }

    private void swap(int[] nums, int from, int to) {
        int temp = nums[from];
        nums[from] = nums[to];
        nums[to] = temp;
    }
}
