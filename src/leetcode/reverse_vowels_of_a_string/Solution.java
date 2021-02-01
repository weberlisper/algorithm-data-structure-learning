package leetcode.reverse_vowels_of_a_string;

public class Solution {

    public String reverseVowels(String s) {
        if (s == null) {
            return null;
        }
        char[] charArr = s.toCharArray();
        int i = 0, j = s.length() - 1;
        while (i < j) {
            while (i < j && !isVowelChar(charArr[i])) {
                i++;
            }
            while (j > i && !isVowelChar(charArr[j])) {
                j--;
            }
            if (i >= j) {
                break;
            }

            char t = charArr[j];
            charArr[j--] = charArr[i];
            charArr[i++] = t;
        }
        return new String(charArr);
    }

    private boolean isVowelChar(char c) {
        return c == 'a'
                || c == 'e'
                || c == 'i'
                || c == 'o'
                || c == 'u'
                || c == 'A'
                || c == 'E'
                || c == 'I'
                || c == 'O'
                || c == 'U';
    }

}
