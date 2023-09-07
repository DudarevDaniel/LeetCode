package fiverr.commonword;

import java.util.*;
import java.util.stream.Collectors;

/**
 * <a href="https://leetcode.com/problems/most-common-word/">LeetCode</a>
 */
public class MostCommonWord {

    public static void main(String[] args) {
        MostCommonWord main = new MostCommonWord();
//        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
//        String paragraph = "Bob";
        String paragraph = "a.";
        String[] banned = new String[]{"hit"};
        String mostCommonWord = main.mostCommonWord(paragraph, banned);
        System.out.println(mostCommonWord);
    }

    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> ignored = new HashSet<>(Arrays.asList(banned));
        Map<String, Integer> wordsWithCount = new HashMap<>();
        List<String> words = splitIntoWords(paragraph).stream()
                .filter(word -> !ignored.contains(word))
                .collect(Collectors.toList());
        for (String word : words) {
            wordsWithCount.merge(word, 1, Integer::sum);
        }
        return findWithBiggestCount(wordsWithCount);
    }

    private List<String> splitIntoWords(String paragraph) {
        List<String> words = new ArrayList<>();
        StringBuilder currentWord = new StringBuilder();
        for (char letter : paragraph.toLowerCase().toCharArray()) {
            if (Character.isLetter(letter)) {
                currentWord.append(letter);
            } else {
                String word = currentWord.toString();
                if (!word.isEmpty()) {
                    words.add(word);
                }
                currentWord = new StringBuilder();
            }
        }
        String word = currentWord.toString();
        if (!word.isEmpty()) {
            words.add(word);
        }
        return words;
    }

    private String findWithBiggestCount(Map<String, Integer> wordsWithCount) {
        int maxCount = 0;
        String word = "";
        for (Map.Entry<String, Integer> wordWithCountEntry : wordsWithCount.entrySet()) {
            if (wordWithCountEntry.getValue() > maxCount) {
                maxCount = wordWithCountEntry.getValue();
                word = wordWithCountEntry.getKey();
            }
        }
        return word;
    }
}
