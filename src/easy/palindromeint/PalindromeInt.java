package easy.palindromeint;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/palindrome-number/
 * Given an integer x, return true if x is a palindrome, and false otherwise.
 */
public class PalindromeInt {

    public static void main(String[] args) {
        PalindromeInt main = new PalindromeInt();
        int input = 1221;
        System.out.println(input + ": " + main.isPalindrome(input));
    }

    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        if (x < 10) return true;
        List<Integer> digits = new ArrayList<>();
        while (x > 0) {
            digits.add(x % 10);
            x = x / 10;
        }

        for (int i = 0; i < digits.size(); i++) {
            int j = digits.size() - 1 - i;
            if (i > j || i == j) return true;
            if (!digits.get(i).equals(digits.get(j))) return false;
        }
        return true;
    }
}
