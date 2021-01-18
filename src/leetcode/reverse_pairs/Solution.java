package leetcode.reverse_pairs;

public class Solution {
    public int reversePairs(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }

        int[] temp = new int[nums.length];
        return sort(nums, 0, nums.length - 1, temp);
    }

    // 对数组data的区间[l .. r]进行排序
    private static int sort(int[] nums, int l, int r, int[] temp) {
        // 最简单的问题
        if (r <= l) {
            return 0;
        }
        // 先求解更小的问题
        int mid = l + (r - l) / 2;
        int leftPairCount = sort(nums, l, mid, temp);
        int rightPairCount = sort(nums, mid + 1, r, temp);
        // 根据最小问题的解解决当前问题
        int curPairCount = 0;
        if (nums[mid] > nums[mid + 1]) {
            curPairCount = merge(nums, l, mid, r, temp);
        }
        return leftPairCount + rightPairCount + curPairCount;
    }

    // 数组data的区间[l .. mid][mid+1 .. r]分别是有序的，对这两个区间的元素进行合并排序
    private static int merge(int[] nums, int l, int mid, int r, int[] temp) {
        System.arraycopy(nums, l, temp, l, r - l + 1);

        int res = 0;
        int i = l;
        int j = mid + 1;
        // k轮询愿数组待操作区域的索引，用于放入新元素
        for (int k = l; k <= r; k++) {
            if (j > r) {
                nums[k] = temp[i++];
            } else if (i > mid) {
                nums[k] = temp[j++];
            } else if (temp[i] <= temp[j]) {
                nums[k] = temp[i++];
            } else {
                nums[k] = temp[j++];
                res += mid - i + 1;
            }
        }
        return res;
    }
}
