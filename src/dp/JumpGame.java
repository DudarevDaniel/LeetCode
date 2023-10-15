package dp;

/**
 * https://leetcode.com/problems/jump-game/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class JumpGame {

    public static void main(String[] args) {
        JumpGame main = new JumpGame();
        int[] nums = new int[]{2, 3, 1, 1, 4};
//        int[] nums = new int[]{3, 2, 1, 0, 4};
        boolean canJump = main.canJump(nums);
        System.out.println(canJump);
    }

    public boolean canJump(int[] nums) {
        if (nums == null || nums.length < 1) return false;
        if (nums.length == 1) return true;

        int[] dp = new int[nums.length];
        return canReach(nums, 0, dp);
    }

    private boolean canReach(int[] nums, int currentIndex, int[] dp) {
        if (dp[currentIndex] == -1) return false;
        System.out.println("canReach: " + currentIndex);
        if (currentIndex >= nums.length - 1) return true;
        int currentMaxJump = nums[currentIndex];
        if (currentMaxJump == 0) return false;
        for (int i = 1; i <= currentMaxJump; i++) {
            if (canReach(nums, currentIndex + i, dp)) {
                return true;
            }
        }
        dp[currentIndex] = -1;
        return false;
    }
}
