package leetcode.minimum_window_substring;

public class Solution {

    public String minWindow(String s, String t) {
        int[] tFreq = new int[256];     // 26个小写字母+26个大写字母，在t中出现的频率

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            tFreq[c]++;
        }

        int[] sFreq = new int[256];

        int start = 0;
        int minLen = s.length() + 1;
        int l = 0, r = -1;  // 窗口的左右边界

        char[] array = s.toCharArray();
        while (l <= array.length - t.length()) {
            if (r + 1 < array.length && // r必须是有效的索引
                    (r - l + 1 < t.length() || !matchFreq(array[r], sFreq, tFreq) || !matchAll(sFreq, tFreq))) {   // 长度不够或者最后一个字符不是t涵盖的字符，或者字符频率不匹配，都要扩充的窗口的右边界
                sFreq[array[++r]]++;
            } else if (matchAll(sFreq, tFreq)) {    // 整个窗口必须匹配
                if (r - l + 1 < minLen && matchFreq(array[l], sFreq, tFreq)) {
                    minLen = r - l + 1;
                    start = l;
                }
                sFreq[array[l++]]--;
            } else {
                break;
            }
        }

        if (minLen == s.length() + 1) {
            return "";
        }
        return s.substring(start, start + minLen);
    }

    private boolean matchAll(int[] sFreq, int[] tFreq) {
        for (int i = 0; i < tFreq.length; i++) {
            if (tFreq[i] != 0 && tFreq[i] > sFreq[i]) {
                return false;
            }
        }
        return true;
    }

    private boolean matchFreq(char c, int[] sFreq, int[] tFreq) {
            return tFreq[c] != 0 && tFreq[c] <= sFreq[c];
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println((new Solution()).minWindow(s, t));
    }

}
