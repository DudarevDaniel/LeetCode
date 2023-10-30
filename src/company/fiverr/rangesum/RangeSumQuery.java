package company.fiverr.rangesum;

/**
 * <a href="https://leetcode.com/problems/range-sum-query-mutable/description/">LeetCode</a>
 */
public class RangeSumQuery {

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        NumArray obj = new NumArray(array);
        System.out.println(obj.sumRange(0, 2));
        obj.update(1, 2);
        int sum = obj.sumRange(0, 2);
        System.out.println(sum);
    }
}

class NumArray {

    private int[] nums;
    private int[] segmentTree;

    public NumArray(int[] nums) {
        this.nums = nums;
        // Calculate the size of the segment tree.
        int treeSize = 2 * getNextPowerOfTwo(nums.length) - 1;
        segmentTree = new int[treeSize];

        // Build the segment tree.
        buildSegmentTree(0, 0, nums.length - 1);
    }

    public void update(int index, int val) {
        updateSegmentTree(0, 0, nums.length - 1, index, val);
    }

    public int sumRange(int left, int right) {
        return querySegmentTree(0, 0, nums.length - 1, left, right);
    }

    private void buildSegmentTree(int treeIndex, int start, int end) {
        if (start == end) {
            // Leaf node, store the element value.
            segmentTree[treeIndex] = nums[start];
        } else {
            int mid = start + (end - start) / 2;
            int leftChildIndex = 2 * treeIndex + 1;
            int rightChildIndex = 2 * treeIndex + 2;

            // Recursively build left and right subtrees.
            buildSegmentTree(leftChildIndex, start, mid);
            buildSegmentTree(rightChildIndex, mid + 1, end);

            // Combine the results from the left and right subtrees.
            segmentTree[treeIndex] = segmentTree[leftChildIndex] + segmentTree[rightChildIndex];
        }
    }

    private int querySegmentTree(int treeIndex, int start, int end, int left, int right) {
        if (start >= left && end <= right) {
            // The current node's range is completely inside the query range.
            return segmentTree[treeIndex];
        } else if (end < left || start > right) {
            // The current node's range is completely outside the query range.
            return 0;
        } else {
            // Partial overlap, so we need to recursively query both subtrees.
            int mid = start + (end - start) / 2;
            int leftChildIndex = 2 * treeIndex + 1;
            int rightChildIndex = 2 * treeIndex + 2;

            int leftSum = querySegmentTree(leftChildIndex, start, mid, left, right);
            int rightSum = querySegmentTree(rightChildIndex, mid + 1, end, left, right);

            return leftSum + rightSum;
        }
    }

    private void updateSegmentTree(int treeIndex, int start, int end, int index, int val) {
        if (start == end) {
            // Leaf node, update the element value.
            nums[index] = val;
            segmentTree[treeIndex] = val;
        } else {
            int mid = start + (end - start) / 2;
            int leftChildIndex = 2 * treeIndex + 1;
            int rightChildIndex = 2 * treeIndex + 2;

            if (index <= mid) {
                // Update in the left subtree.
                updateSegmentTree(leftChildIndex, start, mid, index, val);
            } else {
                // Update in the right subtree.
                updateSegmentTree(rightChildIndex, mid + 1, end, index, val);
            }

            // Recalculate the current node's value after updating the child nodes.
            segmentTree[treeIndex] = segmentTree[leftChildIndex] + segmentTree[rightChildIndex];
        }
    }

    private int getNextPowerOfTwo(int n) {
        int powerOfTwo = 1;
        while (powerOfTwo < n) {
            powerOfTwo *= 2;
        }
        return powerOfTwo;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */
