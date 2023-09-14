package easy.removeelement;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/remove-element/description/?envType=study-plan-v2&envId=top-interview-150">LeetCode</a>
 */
public class RemoveFromArray {

    public static void main(String[] args) {
        RemoveFromArray main = new RemoveFromArray();
//        int[] nums = new int[]{3, 3};
        int[] nums = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
//        int val = 3;
        int val = 2;
        int count = main.removeElement(nums, val);
        System.out.println(count);
        System.out.println(Arrays.toString(nums));
    }

    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1 && nums[0] != val) {
            return 1;
        }
        int count = 0;
        int lastIndex = nums.length - 1;
        for (int i = 0; i <= lastIndex; i++) {
            int current = nums[i];
            if (current == val) {
                while (nums[lastIndex] == current && lastIndex > i) {
                    lastIndex--;
                }
                if (lastIndex != i) {
                    swap(nums, i, lastIndex);
                    count++;
                }
            } else {
                count++;
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
