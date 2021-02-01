package leetcode.two_sum_ii_input_array_is_sorted;

public class Solution {

    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length < 2) {
            return null;
        }
        for (int i = 0; i < numbers.length; i++) {
            int matchIndex = binarySearch(numbers, i + 1, target - numbers[i]);
            if (matchIndex != -1) {
                return new int[]{i + 1, matchIndex + 1};
            }
        }
        return null;
    }

    // 在numbers[l, numbers.length)区间内，寻找等于e的索引，没找到则返回-1
    private int binarySearch(int[] numbers, int l, int e) {
        int r = numbers.length - 1;
        // 循环不变量：在[l, r]区间内寻找元素e
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (numbers[mid] == e) {
                return mid;
            } else if (numbers[mid] > e) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

    public int[] twoSum2(int[] numbers, int target) {
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum == target) {
                return new int[]{i + 1, j + 1};
            } else if (sum < target) {
                i++;
            } else {
                j--;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] numbers = {2, 7, 11, 15};
        (new Solution()).twoSum2(numbers, 9);
    }
}
