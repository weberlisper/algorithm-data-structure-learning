package jianzhi_offer;

public class Solution {
    public int findRepeatNumber(int[] nums) {
        int i = 0;
        // 循环不变量，nums[0 .. i)中元素和下标志相等
        while (i < nums.length) {
            if (i == nums[i]) {
                i++;
                continue;
            }
            int m = nums[i];
            if (m == nums[m]) {
                return m;
            } else {
                swap(nums, i, m);
            }
        }
        return -1;
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[j];
        nums[j] = nums[i];
        nums[i] = t;
    }
}
