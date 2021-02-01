package leetcode.container_with_most_water;

public class Solution {

    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1;
        int maxArea = 0;
        while (i < j) {
            int curArea = (j - i) * Math.min(height[i], height[j]);
            if (curArea > maxArea) {
                maxArea = curArea;
            }
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return maxArea;
    }

}
