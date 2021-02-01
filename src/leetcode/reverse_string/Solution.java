package leetcode.reverse_string;

public class Solution {
    public void reverseString(char[] s) {
        if (s == null) {
            return;
        }
        int i = 0, j = s.length - 1;
        while (i <= j) {
            char t = s[j];
            s[j--] = s[i];
            s[i++] = t;
        }
    }
}
