import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonRepeatingChar {

    // Returns the first non-repeating character, or '\0' if none exists
    static char findFirstNonRepeatingChar(String text) {
        Map<Character, Integer> frequency = new LinkedHashMap<>();

        // Count frequency of every character
        for (char c : text.toCharArray()) {
            frequency.put(c, frequency.getOrDefault(c, 0) + 1);
        }

        // Scan left to right for the first char with frequency == 1
        for (char c : text.toCharArray()) {
            if (frequency.get(c) == 1) {
                return c;
            }
        }

        return '\0'; // sentinel for "not found"
    }

    public static void main(String[] args) {
        String[] testInputs = {"swiss", "aabbcc", "teeter", "programming", "xxyz"};

        for (String input : testInputs) {
            char result = findFirstNonRepeatingChar(input);
            System.out.print("Input: \"" + input + "\" -> ");
            if (result != '\0') {
                System.out.println("First Non-Repeating Character: '" + result + "'");
            } else {
                System.out.println("No Non-Repeating Character Found");
            }
        }
    }
}
