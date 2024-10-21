import java.util.*;

public class WordUtils {
    public static Set<String> removeDuplicates(List<String> words) {
        return new TreeSet<>(words); // TreeSet removes duplicates and sorts
    }

    public static Map.Entry<String, Integer> getMostFrequentWord(List<String> words) {
        Map<String, Integer> wordCountMap = new HashMap<>();
        for (String word : words) {
            wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
        }
        return Collections.max(wordCountMap.entrySet(), Map.Entry.comparingByValue());
    }

    public static List<String> sortWords(Set<String> words, boolean ascending) {
        List<String> wordList = new ArrayList<>(words);
        if (ascending) {
            Collections.sort(wordList); // Ascending order
        } else {
            Collections.sort(wordList, Collections.reverseOrder()); // Descending order
        }
        return wordList;
    }
}
