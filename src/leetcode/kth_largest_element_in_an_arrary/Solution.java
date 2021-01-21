package leetcode.kth_largest_element_in_an_arrary;

import java.util.Random;

public class Solution {

    public int findKthLargest(int[] nums, int k) {
        Random random = new Random();
        return selectK(nums, nums.length - k, 0, nums.length - 1, random);
    }

    // 在数组nums[l..r]中找出第k小的元素，k从0开始
    public int selectK(int[] nums, int k, int l, int r, Random random) {
        int p = partition(nums, l, r, random);
        if (k == p) {
            return nums[p];
        } else if (k > p) {
            return selectK(nums, k, p + 1, r, random);
        } else {
            return selectK(nums, k, l, p - 1, random);
        }
    }

    private int partition(int[] nums, int l, int r, Random random) {
        int p = random.nextInt(r - l + 1) + l;
        swap(nums, l, p);

        int i = l + 1;
        int j = r;
        while (true) {
            while (i <= j && nums[i] < nums[l]) {
                i++;
            }
            while (j >= i && nums[j] > nums[l]) {
                j--;
            }
            if (i >= j) {
                break;
            }
            swap(nums, i, j);
            i++;
            j--;
        }
        swap(nums, l, j);
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int result = (new Solution()).findKthLargest(nums, 2);
        System.out.println(result);
    }
}
