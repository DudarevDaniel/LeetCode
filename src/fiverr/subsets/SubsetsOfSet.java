package fiverr.subsets;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * <a href="https://leetcode.com/problems/subsets/">LeetCode</a>
 */
public class SubsetsOfSet {

    public static void main(String[] args) {
        SubsetsOfSet main = new SubsetsOfSet();
        int[] nums = new int[]{1, 2, 3, 4};
        List<List<Integer>> result = main.subsets(nums);
        System.out.println(result);
    }

    public List<List<Integer>> subsets(int[] nums) {
        if (nums.length == 1) {
            return List.of(Collections.emptyList(), List.of(nums[0]));
        }
        List<List<Integer>> result = new ArrayList<>();
        result.add(Collections.emptyList());
        return buildSubsets(result, nums, 0);
    }

    private List<List<Integer>> buildSubsets(List<List<Integer>> subsets, int[] nums, int currentIndex) {
        if (currentIndex >= nums.length) return subsets;
        List<List<Integer>> updated = new ArrayList<>(subsets);
        for (List<Integer> subset : subsets) {
            List<Integer> newSubset = new ArrayList<>(subset);
            newSubset.add(nums[currentIndex]);
            updated.add(newSubset);
        }
        return buildSubsets(updated, nums, currentIndex + 1);
    }
}
