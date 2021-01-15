package leetcode.remove_linked_list_elements;

public class Sum {

    public static int sum(int[] nums) {
        return sum(nums, 0);
    }

    private static int sum(int[] nums, int l) {
        // 最简单的问题
        if (l == nums.length) {
            return 0;
        }

        // 简化为更小的问题，先求出后面数组的和，再和当前元素相加
        int subSum = sum(nums, l + 1);
        return nums[l] + subSum;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        System.out.println(sum(nums));
    }

}
