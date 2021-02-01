package leetcode.find_all_anagrams_in_a_string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public List<Integer> findAnagrams(String s, String p) {
        if (s == null || p == null || s.length() < p.length()) {
            return new ArrayList<>();
        }

        int[] pFreq = new int[26];
        Arrays.fill(pFreq, 0);
        for (int i = 0; i < p.length(); i++) {
            pFreq[p.charAt(i) - 'a']++;
        }
        int[] wFreq = new int[26];
        Arrays.fill(wFreq, 0);

        List<Integer> res = new ArrayList<>();

        int l = 0, r = -1;
        int pLen = p.length();
        int sLen = s.length();
        while (l <= sLen - pLen) {
            if (r + 1 < sLen && (r - l + 1 < pLen || wFreq[s.charAt(r) - 'a'] != pFreq[s.charAt(r) - 'a'])) { // 当窗口长度小于pLen，并且r处的元素的频率和pFreq中的频率不相等时，扩大右边界
                wFreq[s.charAt(++r) - 'a']++;
            } else {
                if (r - l + 1 == pLen && isAnagrams(wFreq, pFreq)) {
                    res.add(l);
                }
                wFreq[s.charAt(l++) - 'a']--;
            }
        }

        return res;
    }

    private boolean isAnagrams(int[] wFreq, int[] pFreq) {
        for (int i = 0; i < wFreq.length; i++) {
            if (wFreq[i] != pFreq[i]) {
                return false;
            }
        }
        return true;
    }

}
