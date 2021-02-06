package leetcode._3sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                twoSum(nums, -nums[i], i + 1, nums.length - 1, res);
            }
        }
        return res;
    }

    private void twoSum(int[] nums, int target, int start, int end, List<List<Integer>> res) {

        // 循环不变量，在[start, end]的区间外不存在和为target的两个元素
        while (start < end) {
            int sum = nums[start] + nums[end];
            if (sum < target) {   // 右移i，需要注意避免重复元素以及和targetIndex相等
                start++;
            } else if (sum > target) {    // 跳过重复
                end--;
            } else {
                List<Integer> item = new ArrayList<>();
                item.add(-target);
                item.add(nums[start]);
                item.add(nums[end]);
                res.add(item);
                while (start < end && nums[start] == nums[start + 1]) {
                    start++;
                }
                start++;

                while (end > start && nums[end] == nums[end - 1]) {
                    end--;
                }
                end--;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {-4, -1, -1, 0, 1, 2};
        System.out.println(new Solution().threeSum(nums));
    }
}
