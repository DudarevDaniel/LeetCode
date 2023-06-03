package medium.foursum;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/4sum/
 */
public class FourSum {

    public static void main(String[] args) {
        FourSum main = new FourSum();
//        int[] nums = new int[]{1, 0, -1, 0, -2, 2};
//        int target = 0;
//        int[] nums = new int[]{2, 2, 2, 2, 2, 2};
//        int target = 8;
//        int[] nums = new int[]{-3, -1, 0, 2, 4, 5};
//        int target = 0;
        int[] nums = new int[]{-2, -1, -1, 1, 1, 2, 2};
        int target = 0;
        List<List<Integer>> result = main.fourSum(nums, target);
        System.out.println(Arrays.toString(nums));
        System.out.println(result);
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Set<List<Integer>> result = new HashSet<>();
        if (nums.length <= 3) return Collections.emptyList();
        Arrays.sort(nums);
        if (target < nums[0] && nums[0] > 0) return Collections.emptyList();

        int previousFirst = nums[0];
        for (int i = 0; i < nums.length - 3; i++) {
            int first = nums[i];
            if (first == previousFirst && i != 0) {
                continue;
            }
            previousFirst = first;
            int previousSecond = nums[i + 1];
            for (int j = i + 1; j < nums.length - 2; j++) {
                int second = nums[j];
                if (second == previousSecond && j != i + 1) {
                    continue;
                }
                previousSecond = second;
                int indexLeft = j + 1;
                int indexRight = nums.length - 1;
                while (indexLeft < indexRight) {
                    int currentSum = first + second + nums[indexLeft] + nums[indexRight];
                    if (currentSum == target) {
                        result.add(List.of(first, second, nums[indexLeft], nums[indexRight]));
                        indexLeft++;
                        indexRight--;
                    } else if (currentSum < target) {
                        indexLeft++;
                    } else {
                        indexRight--;
                    }
                }
            }
        }
        return new ArrayList<>(result);
    }

}
