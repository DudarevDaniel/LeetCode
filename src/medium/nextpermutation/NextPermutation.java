package medium.nextpermutation;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/next-permutation/
 * The next permutation of an array of integers is the next lexicographically greater permutation of its integer.
 * More formally, if all the permutations of the array are sorted in one container according to their lexicographical order,
 * then the next permutation of that array is the permutation that follows it in the sorted container. If such arrangement is not possible,
 * the array must be rearranged as the lowest possible order (i.e., sorted in ascending order).
 */
public class NextPermutation {

    public void nextPermutation(int[] nums) {
        if (nums.length == 1) return;
        if (nums.length == 2) {
            swapElements(nums, 0, 1);
            return;
        }
        int peakIndex = findIndexOfRightPeak(nums);
        if (peakIndex == -1) {
            invertArray(nums);
            return;
        }

        int leftIndex = peakIndex - 1;
        for (int i = nums.length - 1; i >= peakIndex; i--) {
            if (nums[leftIndex] < nums[i]) {
                swapElements(nums, leftIndex, i);
                sortElements(nums, peakIndex);
                return;
            }
        }
    }

    private void swapElements(int[] nums, int fromIndex, int toIndex) {
        int temp = nums[fromIndex];
        nums[fromIndex] = nums[toIndex];
        nums[toIndex] = temp;
    }

    private void invertArray(int[] nums) {
        int rightIndex = nums.length - 1;
        int leftIndex = 0;
        while (leftIndex < rightIndex) {
            swapElements(nums, leftIndex, rightIndex);
            leftIndex++;
            rightIndex--;
        }
    }

    private void sortElements(int[] nums, int sortFrom) {
        for (int i = sortFrom; i < nums.length; i++) {
            int current = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (current > nums[j]) {
                    current = nums[j];
                    swapElements(nums, i, j);
                }
            }
        }
    }

    int findIndexOfRightPeak(int[] nums) {
        int prevIndex = nums.length - 1;
        int previous = nums[prevIndex];
        for (int a = nums.length - 2; a >= 0; a--) {
            int current = nums[a];
            if (current >= previous) {
                prevIndex = a;
                previous = current;
            } else {
                return prevIndex;
            }
        }
        return -1;
    }
}

class NextPermutationTest {

    NextPermutation main = new NextPermutation();

    public static void main(String[] args) {
        NextPermutationTest test = new NextPermutationTest();
        test.nextPermutation_size1();
        test.nextPermutation_size2();
        test.nextPermutation_size3();
        test.nextPermutation_size4();
        test.nextPermutation_many();
        test.nextPermutation_invert();
        System.out.println("--------");
        test.findIndexOfRightPeak();
    }

    private void findIndexOfRightPeak() {
//        int[] nums = new int[]{4, 3, 2, 1};
        int[] nums = new int[]{1, 2, 2, 1};
        System.out.println("Input: " + Arrays.toString(nums));
        int index = main.findIndexOfRightPeak(nums);
        System.out.println("Index: " + index);
    }

    private void nextPermutation_size1() {
        int[] nums = new int[]{1};
        System.out.println("Input: " + Arrays.toString(nums));
        main.nextPermutation(nums);
        System.out.println("Output: " + Arrays.toString(nums));
    }

    private void nextPermutation_size2() {
        int[] nums = new int[]{1, 3};
        System.out.println("Input: " + Arrays.toString(nums));
        main.nextPermutation(nums);
        System.out.println("Output: " + Arrays.toString(nums));
    }

    private void nextPermutation_size3() {
        int[] nums = new int[]{1, 3, 2};
        System.out.println("Input: " + Arrays.toString(nums));
        main.nextPermutation(nums);
        System.out.println("Output: " + Arrays.toString(nums));
    }

    private void nextPermutation_size4() {
        int[] nums = new int[]{1, 3, 2, 1};
//        int[] nums = new int[]{1, 1, 3, 2};
//        int[] nums = new int[]{2, 1, 1, 3};

//        int[] nums = new int[]{2, 3, 1, 1};
//        int[] nums = new int[]{2, 1, 1, 3};
        System.out.println("Input: " + Arrays.toString(nums));
        main.nextPermutation(nums);
        System.out.println("Output: " + Arrays.toString(nums));
    }

    private void nextPermutation_many() {
        int[] nums = new int[]{4, 2, 0, 2, 3, 2, 0};
        System.out.println("Input: " + Arrays.toString(nums));
        main.nextPermutation(nums);
        System.out.println("Output: " + Arrays.toString(nums));
    }

    private void nextPermutation_invert() {
        int[] nums = new int[]{3, 2, 1};
        System.out.println("Input: " + Arrays.toString(nums));
        main.nextPermutation(nums);
        System.out.println("Output: " + Arrays.toString(nums));
    }
}
