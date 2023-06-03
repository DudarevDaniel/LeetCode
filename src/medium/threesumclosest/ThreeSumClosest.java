package medium.threesumclosest;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/3sum-closest/
 * Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.
 */
public class ThreeSumClosest {

    public static void main(String[] args) {
        ThreeSumClosest main = new ThreeSumClosest();
        int[] nums = new int[]{4, 0, 5, -5, 3, 3, 0, -4, -5};
        int target = -2;
//        int[] nums = new int[]{-100, -98, -2, -1};
//        int target = -101;
//        int[] nums = new int[]{-1, 2, 1, -4};
//        int target = 2;
//        int[] nums = new int[]{1, 1, 1, 1};
//        int target = 0;
        int result = main.threeSumClosest(nums, target);
        System.out.println(Arrays.toString(nums));
        System.out.println(result);
    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int currentBestSum = nums[0] + nums[1] + nums[2];
        if (currentBestSum >= target) return currentBestSum;
        if (nums.length == 3) return currentBestSum;

        for (int i = 0; i < nums.length - 2; i++) {
            int firstSum = nums[i];
            int leftIndex = i + 1;
            int rightIndex = nums.length - 1;
            while (leftIndex < rightIndex) {
                int left = nums[leftIndex];
                int right = nums[rightIndex];
                int currentThirdSum = firstSum + left + right;
                if (currentThirdSum == target) return target;
                currentBestSum = numberCloserToTarget(currentThirdSum, currentBestSum, target);
                if (currentThirdSum < target) {
                    leftIndex++;
                } else {
                    rightIndex--;
                }
            }
        }
        return currentBestSum;
    }

    private int numberCloserToTarget(int a, int b, int target) {
        int diffA = a - target;
        int diffB = b - target;
        return Math.abs(diffA) < Math.abs(diffB) ? a : b;
    }

    private int findClosestInSortedArray(int[] nums,
                                         int startIndex,
                                         int endIndex,
                                         int target) {
        if (startIndex >= endIndex) return nums[endIndex];
        if (target <= nums[startIndex]) return nums[startIndex];
        if (target >= nums[endIndex]) return nums[endIndex];
        if (endIndex - startIndex == 1) return numberCloserToTarget(nums[startIndex], nums[endIndex], target);

        int middleIndex = (startIndex + endIndex) / 2;
        int middleElement = nums[middleIndex];
        if (target == middleElement) return middleElement;
        if (target < middleElement) {
            return findClosestInSortedArray(nums, startIndex, middleIndex, target);
        } else {
            return findClosestInSortedArray(nums, middleIndex, endIndex, target);
        }
    }
}
