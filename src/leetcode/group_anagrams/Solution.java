package leetcode.group_anagrams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            String sortAnagram = toSortAnagram(str);
            if (map.containsKey(sortAnagram)) {
                map.get(sortAnagram).add(str);
            } else {
                List<String> anagramList = new ArrayList<>();
                anagramList.add(str);
                map.put(sortAnagram, anagramList);
            }
        }
        return new ArrayList<>(map.values());
    }

    private String toSortAnagram(String str) {
        int[] freqs = new int[26];
        for (int i = 0; i < str.length(); i++) {
            freqs[str.charAt(i) - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < freqs.length; i++) {
            for (int i1 = 0; i1 < freqs[i]; i1++) {
                sb.append(i + 'a');
            }
        }
        return sb.toString();
    }

}
