public class Main {

    public static int firstBreak(int[] tokens) {
        // A queue of length 0 or 1 is always in order
        if (tokens.length <= 1) return -1;

        for (int i = 1; i < tokens.length; i++) {
            if (tokens[i] < tokens[i - 1]) {
                return i;     // first position that breaks increasing order
            }
        }
        return -1;            // whole queue in order
    }

    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);

        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) continue;

            String[] parts = line.replaceAll("[^0-9\\-]", " ").trim().split("\\s+");
            int[] tokens = new int[parts.length];
            for (int i = 0; i < parts.length; i++) {
                tokens[i] = Integer.parseInt(parts[i]);
            }

            System.out.println(firstBreak(tokens));
        }
    }
}
