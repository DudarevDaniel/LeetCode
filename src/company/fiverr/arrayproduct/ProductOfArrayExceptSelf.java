package company.fiverr.arrayproduct;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/product-of-array-except-self/">LeetCode</a>
 */
public class ProductOfArrayExceptSelf {

    public static void main(String[] args) {
        ProductOfArrayExceptSelf main = new ProductOfArrayExceptSelf();
        int[] nums = new int[]{1, 2, 3, 4};
//        int[] nums = new int[]{-1, 1, 0, -3, 3};
        int[] result = main.productExceptSelf(nums);
        System.out.println(Arrays.toString(result));
    }

    public int[] productExceptSelf(int[] nums) {
        if (nums.length == 1) {
            return nums;
        }
        int[] result = new int[nums.length];
        int currentProduct = 1;
        int numberOfZeros = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                currentProduct = currentProduct * nums[i];
            } else {
                numberOfZeros++;
            }
        }
        if (numberOfZeros > 1) {
            return result;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0 && numberOfZeros == 0) {
                result[i] = currentProduct / nums[i];
            } else if (nums[i] != 0 && numberOfZeros != 0) {
                result[i] = 0;
            } else if (nums[i] == 0) {
                result[i] = currentProduct;
            }
        }
        return result;
    }
}
