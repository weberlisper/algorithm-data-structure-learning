package leetcode.remove_duplicates_from_sorted_array;

public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null) {
            return -1;
        }

        if (nums.length < 2) {
            return nums.length;
        }

        int pre = Integer.MIN_VALUE, k = 0;
        // 循环不变量，nums[0 .. k)之间的值都是非重复排序元素
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != pre) {
                nums[k++] = pre = nums[i];
            }
        }
        return k;
    }
}
