package leetcode.number_of_boomerangs;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int numberOfBoomerangs(int[][] points) {

        int number = 0;
        for (int i = 0; i < points.length; i++) {
            Map<Integer, Integer> map = new HashMap<>();    // 距离 to 频次
            for (int i1 = 0; i1 < points.length; i1++) {
                if (i != i1) {
                    int dis = dis(points[i], points[i1]);
                    map.put(dis, map.getOrDefault(dis, 0) + 1);
                }
            }

            for (Integer freq : map.values()) {
                number += (freq) * (freq - 1);
            }
        }
        return number;
    }

    private int dis(int[] p1, int[] p2) {
        return (p2[0] - p1[0]) * (p2[0] - p1[0]) + (p2[1] - p1[1]) * (p2[1] - p1[1]);
    }
}
