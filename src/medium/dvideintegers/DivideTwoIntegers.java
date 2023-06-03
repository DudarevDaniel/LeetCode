package medium.dvideintegers;

/**
 * https://leetcode.com/problems/divide-two-integers/
 */
public class DivideTwoIntegers {

    public static void main(String[] args) {
        DivideTwoIntegers main = new DivideTwoIntegers();
        int dividend = -2147483648;
//        int dividend = -10;
        int divisor = 2;
//        int divisor = 3;
        int quotient = main.divide(dividend, divisor);
        System.out.println(dividend + " / " + divisor + " = " + quotient);
    }

    public int divide(int dividend, int divisor) {
        if (divisor == 0) {
            throw new IllegalArgumentException();
        }
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        if (divisor == 1) return dividend;
        if (divisor == -1) return -dividend;
        int adjustment = 0;
        if (dividend == Integer.MIN_VALUE) {
            dividend += 1;
            adjustment += 1;
        }
        if (Math.abs(dividend) < Math.abs(divisor)) {
            return 0;
        }
        int tempDividend = Math.abs(dividend);
        int tempDivisor = Math.abs(divisor);
        int result = 0;
        for (int i = 31; i >= 0; i--) {
            if (((tempDividend - adjustment) >> i) >= tempDivisor) {
                tempDividend = tempDividend - (tempDivisor << i);
                if (adjustment > 0) {
                    tempDividend += adjustment;
                    adjustment--;
                }
                result = result + (1 << i);
            }
        }
        return shouldBePositive(dividend, divisor) ? result : -result;
    }

    /**
     * Inefficient
     */
    public int divideInefficiently(int dividend, int divisor) {
        if (divisor == 0) {
            throw new IllegalArgumentException();
        }
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        boolean positive = shouldBePositive(dividend, divisor);
        if (divisor == 1) return dividend;
        if (divisor == -1) return -dividend;
        if (Math.abs(dividend) < Math.abs(divisor)) {
            return 0;
        }
        long sum = 0;
        int result = 0;
        while (Math.abs(dividend) > Math.abs(sum) && (Math.abs(dividend) - Math.abs(sum)) >= Math.abs(divisor)) {
            if (positive) {
                sum += divisor;
                result++;
                if (sum >= Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }
            } else {
                sum -= divisor;
                result--;
                if (sum <= Integer.MIN_VALUE) {
                    return Integer.MIN_VALUE;
                }
            }
        }

        return result;
    }

    private boolean shouldBePositive(int dividend, int divisor) {
        return (dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0);
    }
}
