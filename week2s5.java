import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class StopWordFrequencyReport {

    private static final Set<String> STOP_WORDS = new HashSet<>(
            Arrays.asList("the", "was", "and", "a", "is", "of", "in")
    );

    // Prints word frequencies (excluding stop words), sorted by count descending
    static void printFilteredWordFrequency(String feedback) {
        // Normalize: lowercase and strip common punctuation
        String cleaned = feedback.toLowerCase()
                .replace(".", "")
                .replace(",", "")
                .replace("!", "")
                .replace("?", "");

        String[] words = cleaned.split("\\s+");

        // Count frequency of non-stop words, preserving first-seen order for stable tie output
        Map<String, Integer> frequency = new LinkedHashMap<>();
        for (String word : words) {
            if (word.isEmpty() || STOP_WORDS.contains(word)) continue;
            frequency.put(word, frequency.getOrDefault(word, 0) + 1);
        }

        // Sort entries by count descending (stable sort keeps insertion order for ties)
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(frequency.entrySet());
        entries.sort(Comparator.comparingInt((Map.Entry<String, Integer> e) -> e.getValue()).reversed());

        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        String feedback = "The mentor was great, the session was great and clear.";
        System.out.println("Input: \"" + feedback + "\"\n");
        printFilteredWordFrequency(feedback);
    }
}
