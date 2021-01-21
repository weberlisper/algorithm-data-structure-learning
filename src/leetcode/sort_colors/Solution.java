package leetcode.sort_colors;

public class Solution {

    public void sortColors(int[] nums) {
        int zh = -1;    // 等于0区间的最高位
        int sl = nums.length; // 等于2区间的最地位
        int i = 0;  // 遍历未处理区域
        // 循环不遍历：nums[0, zh] == 0, nums[zh+1, i-1] == 1, nums[sl, nums.length-1] == 2
        while (i < sl) {
            if (nums[i] == 0) {
                zh++;
                swap(nums, i, zh);
                i++;
            } else if (nums[i] == 2) {
                sl--;
                swap(nums, i, sl);
            } else {
                i++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }

}
