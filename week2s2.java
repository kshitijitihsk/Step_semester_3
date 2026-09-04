public class WordReversalEncoder {

    // Reverses each word in the sentence individually, keeping word order intact
    static String reverseEachWord(String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            StringBuilder reversedWord = new StringBuilder();
            String word = words[i];

            for (int j = word.length() - 1; j >= 0; j--) {
                reversedWord.append(word.charAt(j));
            }

            result.append(reversedWord);
            if (i < words.length - 1) {
                result.append(" ");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String[] testSentences = {"hello club", "coding is fun", "Java"};

        for (String sentence : testSentences) {
            System.out.println("Input: \"" + sentence + "\" -> Output: \"" + reverseEachWord(sentence) + "\"");
        }
    }
}
