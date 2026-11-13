import java.util.*;

public class Main {

    public static int prizeTable(int[] marks) {
        int swaps = 0;
        int n = marks.length;

        for (int i = 0; i < n - 1; i++) {
            int maxIdx = i;

            // find the largest mark among positions i..n-1
            for (int j = i + 1; j < n; j++) {
                if (marks[j] > marks[maxIdx]) {
                    maxIdx = j;
                }
            }

            // only count a swap when the largest is NOT already in place
            if (maxIdx != i) {
                int temp = marks[i];
                marks[i] = marks[maxIdx];
                marks[maxIdx] = temp;
                swaps++;
            }
        }

        System.out.println(Arrays.toString(marks) + " swaps = " + swaps);
        return swaps;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) continue;

            // Accept "marks = [45, 90, 60, 75]" or "45 90 60 75"
            String[] parts = line.replaceAll("[^0-9\\-]", " ").trim().split("\\s+");
            int[] marks = new int[parts.length];
            for (int i = 0; i < parts.length; i++) {
                marks[i] = Integer.parseInt(parts[i]);
            }

            prizeTable(marks);
        }
    }
}
