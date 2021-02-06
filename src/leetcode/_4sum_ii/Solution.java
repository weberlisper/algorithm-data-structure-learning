package leetcode._4sum_ii;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        // 将A和B的所有和放入一个map，并记录他们的频次
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            for (int i1 = 0; i1 < B.length; i1++) {
                int sum = A[i] + B[i1];
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }

        int count = 0;
        for (int i = 0; i < C.length; i++) {
            for (int i1 = 0; i1 < D.length; i1++) {
                if (map.containsKey(-C[i] - D[i1])) {
                    count += map.get(-C[i] - D[i1]);
                }
            }
        }
        return count;
    }
}
