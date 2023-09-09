package fiverr.reversewords;

/**
 * <a href="https://leetcode.com/problems/reverse-words-in-a-string/">LeetCode</a>
 */
public class ReverseWordsInString {

    public static void main(String[] args) {
        ReverseWordsInString main = new ReverseWordsInString();
//        String s = "  hello world  ";
        String s = "a good   example";
        String result = main.reverseWords(s);
        System.out.println(result);
    }

    public String reverseWords(String s) {
        s = s.trim();
        if (s.isEmpty()) return s;
        StringBuilder result = new StringBuilder();
        StringBuilder currentWord = new StringBuilder();
        for (char letter : s.toCharArray()) {
            if (letter != ' ') {
                currentWord.append(letter);
            } else {
                if (currentWord.length() > 0) {
                    result.insert(0, currentWord.append(' '));
                    currentWord = new StringBuilder();
                }
            }
        }
        if (currentWord.length() > 0) {
            result.insert(0, currentWord.append(' '));
        }
        return result.toString().trim();
    }
}
