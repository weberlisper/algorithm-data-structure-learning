package leetcode.move_zeros;

import java.util.Arrays;

public class Solution {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }

        for (int i = 0; i < nums.length; ) {
            if (nums[i] == 0) {
                int j = i + 1;
                while (j < nums.length && nums[j] == 0) {
                    j++;
                }
                if (j == nums.length) {
                    return;
                } else {
                    swap(nums, i, j);
                    i++;
                }
            } else {
                i++;
            }
        }
    }

    public void moveZeroes2(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }

        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i != k) {
                    swap(nums, k, i);
                }
                k++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[j];
        nums[j] = nums[i];
        nums[i] = t;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        (new Solution()).moveZeroes2(nums);
        System.out.println(Arrays.toString(nums));
    }
}
