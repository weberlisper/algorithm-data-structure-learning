package leetcode.contains_duplicate_ii;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null) {
            return false;
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }

            set.add(nums[i]);

            // 保持窗口中只有k个元素
            if (set.size() == k + 1) {
                set.remove(nums[i - k]);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        System.out.println(new Solution().containsNearbyDuplicate(nums, 2));
    }
}
