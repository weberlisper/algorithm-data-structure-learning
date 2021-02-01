package leetcode.minimum_size_subarray_sum;

public class Solution {

    public int minSubArrayLen(int s, int[] nums) {
        int l = 0, r = -1;
        int minLen = nums.length + 1;
        int sum = 0;
        // 循环不变量：nums[l, r]区间元素<s
        while (l < nums.length) {
            if (r + 1 < nums.length && sum < s) {
                sum += nums[++r];
            } else if (sum >= s) {
                minLen = Math.min(minLen, r - l + 1);
                sum -= nums[l++];
            } else {
                break;
            }
        }

        if (minLen == nums.length + 1) {
            return 0;
        }
        return minLen;
    }

}
