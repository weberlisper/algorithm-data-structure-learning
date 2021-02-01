package leetcode.valid_palindrome;

public class Solution {

    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }

        int i = 0, j = s.length() - 1;
        while (i <= j) {
            while (i <= j && !validChar(s.charAt(i))) {
                i++;
            }
            while (j >= i && !validChar(s.charAt(j))) {
                j--;
            }

            if (i > j) {
                break;
            }
            if (!equalsIgnoreCase(s.charAt(i), s.charAt(j))) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    private boolean equalsIgnoreCase(char c1, char c2) {
        if (c1 >= 'a' && c1 <= 'z') {
            return c1 - 'a' == c2 - 'a' || c1 - 'a' == c2 - 'A';
        } else if (c1 >= 'A' && c1 <= 'Z') {
            return c1 - 'A' == c2 - 'a' || c1 - 'A' == c2 - 'A';
        } else {
            return c1 == c2;
        }
    }

    private boolean validChar(char c) {
        return (c >= 'a' && c <= 'z')
                || (c >= '0' && c <= '9')
                || (c >= 'A' && c <= 'Z');
    }

    public static void main(String[] args) {
        String s = "race a car";
        System.out.println((new Solution()).isPalindrome(s));
    }

}
