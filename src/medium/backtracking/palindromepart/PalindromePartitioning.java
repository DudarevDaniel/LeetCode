package medium.backtracking.palindromepart;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/palindrome-partitioning/
 */
public class PalindromePartitioning {

    public static void main(String[] args) {
        PalindromePartitioning main = new PalindromePartitioning();
        String s = "aab";
        List<List<String>> partition = main.partition(s);
        System.out.println(partition);
    }

    public List<List<String>> partition(String s) {
        if (s == null || s.isEmpty()) return new ArrayList<>();
        List<List<String>> result = new ArrayList<>();
        backtrack(s, new LinkedList<>(), result);
        return result;
    }

    private void backtrack(String s, LinkedList<String> currentPalindromes, List<List<String>> result) {
        System.out.println("Incoming string: " + s + ". Current palindromes: " + currentPalindromes);
        if (s.isEmpty()) {
            result.add(new ArrayList<>(currentPalindromes));
            return;
        }

        for (int i = 1; i <= s.length(); i++) {
            String candidate = s.substring(0, i);
            System.out.println("Candidate: " + candidate);
            if (isPalindrome(candidate)) {
                currentPalindromes.add(candidate);
                backtrack(s.substring(i), currentPalindromes, result);
                currentPalindromes.removeLast();
            }
        }
    }

    private boolean isPalindrome(String s) {
        if (s.length() == 0) return false;
        if (s.length() == 1) return true;

        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
