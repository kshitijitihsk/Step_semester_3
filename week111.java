import java.util.*;

public class Main {

    public static void lineUp(int[] heights) {
        int n = heights.length;

        for (int pass = 1; pass <= n - 1; pass++) {
            boolean swapped = false;

            // one left-to-right sweep
            for (int j = 0; j < n - pass; j++) {
                if (heights[j] > heights[j + 1]) {
                    int temp = heights[j];
                    heights[j] = heights[j + 1];
                    heights[j + 1] = temp;
                    swapped = true;
                }
            }

            // print the whole line after this sweep
            System.out.println("Pass " + pass + ": " + Arrays.toString(heights));

            // if nothing moved, the line is already in order
            if (!swapped) break;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) continue;

            // Accept "heights = [4, 2, 5, 1]" or "4 2 5 1"
            String[] parts = line.replaceAll("[^0-9\\-]", " ").trim().split("\\s+");
            int[] heights = new int[parts.length];
            for (int i = 0; i < parts.length; i++) {
                heights[i] = Integer.parseInt(parts[i]);
            }

            lineUp(heights);
            System.out.println();   // blank line between test cases
        }
    }
}
