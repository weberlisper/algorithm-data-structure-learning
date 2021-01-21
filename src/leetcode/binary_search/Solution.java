package leetcode.binary_search;

public class Solution {

    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return -1;
    }

    public int searchR(int[] nums, int target) {
        return searchR(nums, 0, nums.length - 1, target);
    }

    public int searchR(int[] data, int l, int r, int target) {

        if (l > r) {
            return -1;
        }

        int mid = l + (r - l) / 2;
        if (data[mid] == target) {
            return mid;
        }

        if (data[mid] < target) {
            return searchR(data, mid + 1, r, target);
        }

        return searchR(data, l, mid - 1, target);
    }

}
