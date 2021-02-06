package leetcode.word_pattern;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean wordPattern(String pattern, String s) {
        if (pattern == null || s == null) {
            return false;
        }

        char[] patternArr = pattern.toCharArray();
        String[] sArr = s.split(" ");
        if (patternArr.length != sArr.length) {
            return false;
        }
        Map map = new HashMap();
        for (int i = 0; i < patternArr.length; i++) {
            Object pre1 = map.put(patternArr[i], i);
            Object pre2 = map.put(sArr[i], i);
            if (pre1 == null && pre2 == null) {
                continue;
            } else if (pre1 == null) {
                return false;
            } else if (pre2 == null) {
                return false;
            }
            if (!pre1.equals(pre2)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String pattern = "ccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccdd";
        String s = "s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s t t";
        System.out.println(new Solution().wordPattern(pattern, s));
    }
}
