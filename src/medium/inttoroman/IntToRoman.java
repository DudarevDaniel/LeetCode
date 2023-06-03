package medium.inttoroman;

import java.util.*;

/**
 * https://leetcode.com/problems/integer-to-roman/
 */
public class IntToRoman {

    private final Map<Integer, RomanDigitLetters> primitivesByLevel = Map.of(
            0, new RomanDigitLetters("I", "V", "X"),
            1, new RomanDigitLetters("X", "L", "C"),
            2, new RomanDigitLetters("C", "D", "M"),
            3, new RomanDigitLetters("M", null, null)
    );

    public static void main(String[] args) {
        IntToRoman main = new IntToRoman();

        String roman1 = main.intToRoman(1);
        String roman3 = main.intToRoman(3);
        String roman4 = main.intToRoman(4);
        String roman5 = main.intToRoman(5);
        String roman6 = main.intToRoman(6);
        String roman9 = main.intToRoman(9);
        String roman10 = main.intToRoman(10);
        String roman11 = main.intToRoman(11);
        System.out.println(roman1);
        System.out.println(roman3);
        System.out.println(roman4);
        System.out.println(roman5);
        System.out.println(roman6);
        System.out.println(roman9);
        System.out.println(roman10);
        System.out.println(roman11);
    }

    public String intToRoman(int num) {
        if (num < 1 || num > 3999) {
            return null;
        }
        return intToRomanInternal(num, "", 0);
    }

    private String intToRomanInternal(int num, String result, int level) {
        int decim = num / 10;
        int remain = num % 10;
        if (decim == 0 && remain == 0) return result;
        if (remain == 0) return intToRomanInternal(decim, result, level + 1);

        RomanDigitLetters current = primitivesByLevel.get(level);
        String currentLetter = current.digitToRomanLetter(remain);
        return intToRomanInternal(decim, currentLetter + result, level + 1);
    }

    private class RomanDigitLetters {
        private int minorLetterDigit = 1;
        private int majorLetterDigit = 5;
        private String minorLetter;
        private String majorLetter;
        private String nextMinorLetter;

        public RomanDigitLetters(String minorLetter, String majorLetter, String nextMinorLetter) {
            this.minorLetter = minorLetter;
            this.majorLetter = majorLetter;
            this.nextMinorLetter = nextMinorLetter;
        }

        public String digitToRomanLetter(int digit) {
            if (digit == 0) {
                return "";
            }
            if (digit == minorLetterDigit) {
                return minorLetter;
            }
            if (digit == majorLetterDigit) {
                return majorLetter;
            }
            if (digit <= minorLetterDigit + 2) {
                return minorLetter.repeat(digit);
            }
            if (digit == minorLetterDigit + 3) {
                return minorLetter + majorLetter;
            }
            if (digit <= majorLetterDigit + 3) {
                return majorLetter + minorLetter.repeat(digit - majorLetterDigit);
            }
            return minorLetter + nextMinorLetter;
        }

    }
}
