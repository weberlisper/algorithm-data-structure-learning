package leetcode.longest_substring_without_repeating_characters;

import java.util.Arrays;

public class Solution {

    public int lengthOfLongestSubstring(String s) {

        byte[] freq = new byte[256];
        Arrays.fill(freq, (byte) 0);

        int l = 0, r = -1;
        int longestLen = 0;
        char[] array = s.toCharArray();
        while (l < array.length) {
            if (r + 1 < array.length && freq[array[r + 1]] == 0) {  // 没有重复的情况
                freq[array[++r]]++;
            } else {
                longestLen = Math.max(longestLen, r - l + 1);
                freq[array[l++]]--;
            }
        }

        return longestLen;
    }

}
