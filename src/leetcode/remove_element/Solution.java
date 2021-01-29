package leetcode.remove_element;

public class Solution {
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // 在(k, nums.length)中，都是无用的元素
        int k = nums.length - 1;
        for (int i = 0; i <= k; ) {
            if (nums[i] == val) {
                if (i != k) {
                    swap(nums, i, k);
                }
                k--;
            } else {
                i++;
            }
        }
        return k + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[j];
        nums[j] = nums[i];
        nums[i] = t;
    }
}
