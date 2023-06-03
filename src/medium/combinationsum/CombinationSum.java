package medium.combinationsum;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Backtracking
 * https://leetcode.com/problems/combination-sum/
 */
public class CombinationSum {

    public static void main(String[] args) {
        CombinationSum main = new CombinationSum();
//        int[] candidates = new int[]{2, 3, 6, 7};
        int[] candidates = new int[]{2, 3, 5};
//        int target = 7;
        int target = 8;
        List<List<Integer>> result = main.combinationSum(candidates, target);
        System.out.println(result);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return Collections.emptyList();
        }
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        findCombinations(candidates, new ArrayList<>(), target, 0, result);
        return new ArrayList<>(result);
    }

    private void findCombinations(int[] candidates, List<Integer> currentCombination, int target, int startIndex, List<List<Integer>> result) {
        if (startIndex >= candidates.length) return;
        if (target < 0) return;
        if (target == 0) {
            result.add(new ArrayList<>(currentCombination));
            return;
        }

        for (int i = startIndex; i < candidates.length; i++) {
            int candidate = candidates[i];
            currentCombination.add(candidate);
            findCombinations(candidates, currentCombination, target - candidate, i, result); // not i + 1 because we can reuse same elements
            currentCombination.remove(currentCombination.size() - 1);
        }
    }

}
