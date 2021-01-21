package leetcode.zui_xiao_de_kge_shu_icof;

import java.util.Arrays;
import java.util.Random;

public class Solution {

    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0) {
            return new int[0];
        }
        Random random = new Random();
        selectK(arr, k - 1, 0, arr.length - 1, random);
        return Arrays.copyOf(arr, k);
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
}
