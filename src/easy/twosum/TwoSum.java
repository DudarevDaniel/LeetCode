package easy.twosum;

import java.util.*;

/**
 * https://leetcode.com/problems/two-sum/
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * You can return the answer in any order.
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return new int[]{-1, -1};
        }
        Map<Integer, Integer> numsSet = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            numsSet.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            Integer secondPart = numsSet.get(target - current);
            if (secondPart != null && secondPart != i) {
                return new int[]{i, secondPart};
            }
        }
        return new int[]{-1, -1};
    }

}
