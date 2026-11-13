import java.util.*;

public class Main {

    public static int[] diceSort(int[] rolls) {
        // count[v] = how many times value v was thrown
        int[] count = new int[7];                  // indices 1..6 used

        for (int r : rolls) {
            if (r >= 1 && r <= 6) {
                count[r]++;
            }
        }

        // print the counts in the required format
        System.out.print("Counts: ");
        for (int v = 1; v <= 6; v++) {
            System.out.print(v + ":" + count[v] + (v < 6 ? " " : ""));
        }
        System.out.println();

        // build the sorted array using only the counts
        int[] sorted = new int[rolls.length];
        int idx = 0;
        for (int v = 1; v <= 6; v++) {
            for (int k = 0; k < count[v]; k++) {
                sorted[idx++] = v;
            }
        }

        System.out.println("Sorted: " + Arrays.toString(sorted));
        return sorted;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        if (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] parts = line.replaceAll("[^0-9\\-]", " ").trim().split("\\s+");
            int[] rolls = new int[parts.length];
            for (int i = 0; i < parts.length; i++) {
                rolls[i] = Integer.parseInt(parts[i]);
            }
            diceSort(rolls);
        }
    }
}
