public class PalindromeChecker {

    // Approach 1: Iterative — two-pointer comparison
    static boolean isPalindromeIterative(String text) {
        String s = text.replaceAll("\\s+", "").toLowerCase();
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }

    // Approach 2: Recursive — shrink substring from both ends
    static boolean isPalindromeRecursive(String text) {
        String s = text.replaceAll("\\s+", "").toLowerCase();
        return isPalindromeRecursiveHelper(s, 0, s.length() - 1);
    }

    private static boolean isPalindromeRecursiveHelper(String s, int left, int right) {
        if (left >= right) return true;
        if (s.charAt(left) != s.charAt(right)) return false;
        return isPalindromeRecursiveHelper(s, left + 1, right - 1);
    }

    // Approach 3: Array reversal — reverse char array and compare
    static boolean isPalindromeArrayReversal(String text) {
        String s = text.replaceAll("\\s+", "").toLowerCase();
        char[] original = s.toCharArray();
        char[] reversed = new char[original.length];

        for (int i = 0; i < original.length; i++) {
            reversed[i] = original[original.length - 1 - i];
        }

        return new String(original).equals(new String(reversed));
    }

    private static String label(boolean result) {
        return result ? "Palindrome" : "Not Palindrome";
    }

    public static void main(String[] args) {
        String[] testInputs = {"madam", "hello", "Racecar", "A man a plan a canal Panama", "java"};

        for (String input : testInputs) {
            boolean iterative = isPalindromeIterative(input);
            boolean recursive = isPalindromeRecursive(input);
            boolean arrayReversal = isPalindromeArrayReversal(input);

            System.out.println("Input: \"" + input + "\"");
            System.out.println("Iterative: " + label(iterative) +
                    " | Recursive: " + label(recursive) +
                    " | Array Reversal: " + label(arrayReversal));

            boolean allAgree = (iterative == recursive) && (recursive == arrayReversal);
            System.out.println("All approaches agree: " + allAgree + "\n");
        }
    }
}
