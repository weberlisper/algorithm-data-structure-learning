package leetcode.happy_number;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public boolean isHappy(int n) {
        return isHappy(new HashSet<>(), n);
    }

    private boolean isHappy(Set<Integer> set, int n) {
        int powerSum = calPowerSum(n);
        if (powerSum == 1) {
            return true;
        } else if (set.contains(powerSum)) {
            return false;
        } else {
            set.add(powerSum);
            return isHappy(set, powerSum);
        }
    }

    private int calPowerSum(int n) {
        int sum = 0;
        while (n > 0) {
            int bit = n % 10;
            sum += bit * bit;
            n = n / 10;
        }
        return sum;
    }

}
