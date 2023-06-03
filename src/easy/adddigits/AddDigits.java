package easy.adddigits;

/**
 * https://leetcode.com/problems/add-digits/
 * Given an integer num, repeatedly add all its digits until the result has only one digit, and return it.
 */
public class AddDigits {

    public static void main(String[] args) {
        AddDigits main = new AddDigits();
        System.out.println(main.addDigits(147));
    }

    public int addDigits(int num) {
        if (num == 0) return 0;
        int result = getSumOfDigits(num);
        while (result / 10 >= 1) {
            result = getSumOfDigits(result);
        }
        return result;
    }

    private int getSumOfDigits(int num) {
        if (num == 0) return 0;
        int result = 0;
        while (num / 10 >= 1) {
            result = result + num % 10;
            num = num / 10;
        }
        return result + num;
    }
}
