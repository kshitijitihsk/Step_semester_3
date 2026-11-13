import java.util.*;

public class Main {

    public static void shelf(int[] books) {
        int n = books.length;

        // First book is trivially "placed"; start from index 1
        for (int i = 1; i < n; i++) {
            int newBook = books[i];
            int j = i - 1;

            // slide every bigger book on the left one step right
            while (j >= 0 && books[j] > newBook) {
                books[j + 1] = books[j];
                j--;
            }

            // drop the new book into the gap
            books[j + 1] = newBook;

            System.out.println("After placing " + newBook + ": " + Arrays.toString(books));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) continue;

            String[] parts = line.replaceAll("[^0-9\\-]", " ").trim().split("\\s+");
            int[] books = new int[parts.length];
            for (int i = 0; i < parts.length; i++) {
                books[i] = Integer.parseInt(parts[i]);
            }

            shelf(books);
            System.out.println();
        }
    }
}
