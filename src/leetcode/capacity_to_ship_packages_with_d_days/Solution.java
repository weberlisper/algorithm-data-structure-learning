package leetcode.capacity_to_ship_packages_with_d_days;

import java.util.Arrays;

public class Solution {
    public int shipWithinDays(int[] weights, int D) {

        int l = Arrays.stream(weights).max().getAsInt(), r = Arrays.stream(weights).sum();
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (days(weights, mid) > D) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }

    private int days(int[] weights, int k) {
        int cur = 0, days = 0;
        for (int weight : weights) {
            if (cur + weight <= k) {
                cur += weight;
            } else {
                cur = weight;
                days++;
            }
        }
        // 最后一天
        days++;
        return days;
    }

    public static void main(String[] args) {
        int[] weights = {1, 2, 3, 1, 1};
        System.out.println((new Solution()).shipWithinDays(weights, 5));
    }

}
