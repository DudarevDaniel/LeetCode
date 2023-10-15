package dp;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/jump-game-ii/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class JumpGameII {

    public static void main(String[] args) {
        JumpGameII main = new JumpGameII();
//        int[] nums = new int[]{2, 3, 1, 1, 4};
        int[] nums = new int[]{1, 2, 1, 1, 1};
//        int[] nums = new int[]{3, 2, 1, 0, 4};
        int jumps = main.jump(nums);
        System.out.println(jumps);
    }

    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[n - 1] = 0;

        for (int i = n - 2; i >= 0; i--) {
            if (i + nums[i] >= n - 1) {
                dp[i] = 1; // If a jump can directly reach the end, set 1 jump.
            } else {
                int minJumps = Integer.MAX_VALUE;
                for (int j = 1; j <= nums[i] && i + j < n; j++) {
                    minJumps = Math.min(minJumps, dp[i + j]);
                }
                if (minJumps != Integer.MAX_VALUE) {
                    dp[i] = minJumps + 1;
                }
            }
        }

        return dp[0];
    }

}
