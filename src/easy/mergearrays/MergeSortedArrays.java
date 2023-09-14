package easy.mergearrays;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/merge-sorted-array/description/?envType=study-plan-v2&envId=top-interview-150">LeetCode</a>
 */
public class MergeSortedArrays {

    public static void main(String[] args) {
        MergeSortedArrays main = new MergeSortedArrays();
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
//        int[] nums1 = new int[]{2, 0};
        int m = 3;
//        int m = 1;
        int[] nums2 = new int[]{2, 5, 6};
//        int[] nums2 = new int[]{1};
        int n = 3;
//        int n = 1;
        main.merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0) {
            if (n >= 0) System.arraycopy(nums2, 0, nums1, 0, n);
            return;
        }
        if (n == 0) {
            return;
        }

        int firstPointer = m - 1;
        int secondPointer = n - 1;
        int insertIndex = nums1.length - 1;
        while (insertIndex >= 0) {
            if (firstPointer < 0) {
                System.arraycopy(nums2, 0, nums1, 0, secondPointer + 1);
                return;
            }
            if (secondPointer < 0) {
                return;
            }
            int first = nums1[firstPointer];
            int second = nums2[secondPointer];
            if (first <= second) {
                nums1[insertIndex] = second;
                secondPointer--;
            } else {
                nums1[insertIndex] = first;
                nums1[firstPointer] = Integer.MIN_VALUE;
                firstPointer--;
            }
            insertIndex--;
        }
    }
}
