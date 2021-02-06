package leetcode._4sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums == null || nums.length < 4) {
            return new ArrayList<>();
        }

        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {   // 跳过重复元素
                continue;
            }
            threeSum(nums, target - nums[i], nums[i], i + 1, res);
        }
        return res;
    }

    private void threeSum(int[] nums, int target, int value, int start, List<List<Integer>> res) {

        for (int i = start; i < nums.length - 2; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }

            twoSum(nums, target - nums[i], value, nums[i], i + 1, res);
        }

    }

    private void twoSum(int[] nums, int target, int value1, int value2, int start, List<List<Integer>> res) {
        int end = nums.length - 1;
        while (start < end) {
            int sum = nums[start] + nums[end];
            if (sum < target) {
                start++;
            } else if (sum > target) {
                end--;
            } else {
                List<Integer> item = new ArrayList<>();
                item.add(value1);
                item.add(value2);
                item.add(nums[start]);
                item.add(nums[end]);
                res.add(item);

                while (start < end && nums[start + 1] == nums[start]) {
                    start++;
                }
                start++;

                while (start < end && nums[end - 1] == nums[end]) {
                    end--;
                }
                end--;
            }
        }
    }
}
