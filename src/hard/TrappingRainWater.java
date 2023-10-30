package hard;

/**
 * https://leetcode.com/problems/trapping-rain-water/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class TrappingRainWater {

    public static void main(String[] args) {
        TrappingRainWater main = new TrappingRainWater();
        int[] height = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int trapped = main.trap(height);
        System.out.println(trapped);
    }

    public int trap(int[] height) {
        if (height.length <= 2) return 0;

        int trapped = 0;
        int currentTrapped = 0;
        int leftHeight = 0;
        int leftIndex = 0;
        for (int i = 0; i < height.length; i++) {
            int currentHeight = height[i];
            if (currentHeight >= leftHeight) {
                trapped = trapped + currentTrapped;
                leftHeight = currentHeight;
                leftIndex = i;
                currentTrapped = 0;
            } else {
                currentTrapped = currentHeight + (leftHeight - currentTrapped);
                if (i > 1 && currentHeight > height[i - 1]) {
                    int maybeTrapped = 0;
                    for (int j = i - 1; j > leftIndex; j--) {
                        if (height[j] < currentHeight) {
                            maybeTrapped = maybeTrapped + (currentHeight - height[j]);
                        }

                    }
                }
            }
        }
        return trapped;
    }
}
