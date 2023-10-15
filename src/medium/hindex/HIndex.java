package medium.hindex;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/h-index/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class HIndex {

    public static void main(String[] args) {
        HIndex main = new HIndex();
//        int[] citations = new int[]{3, 0, 6, 1, 5};
        int[] citations = new int[]{0, 0, 4, 4};
//        int[] citations = new int[]{0, 1, 3, 5, 6};
//        int[] citations = new int[]{1, 3, 1};
//        int[] citations = new int[]{0, 0, 1};
//        int[] citations = new int[]{0, 1};
//        int[] citations = new int[]{1, 2};
//        int[] citations = new int[]{2, 3};
        int hIndex = main.hIndex(citations);
        System.out.println(hIndex);
    }

    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        int hIndex = 0;

        for (int i = 0; i < n; i++) {
            int smallerCitations = Math.min(citations[i], n - i);
            hIndex = Math.max(hIndex, smallerCitations);
        }

        return hIndex;
    }

    private int search(int[] citations, int left, int right) {
        if (left >= right) {
            return 0;
        }
        if (right - left == 1) {
            int leftCitation = citations[left];
            if (leftCitation >= 2) {
                return 2;
            } else if (leftCitation == 0 && citations[right] > 0) {
                return 1;
            } else {
                return leftCitation;
            }
        }

        int mid = left + (right - left) / 2;
        boolean isRight = (right - mid) <= citations[mid];
        if (isRight) {
            return citations[mid];
        } else {
            return search(citations, mid, right);
        }
    }

}
