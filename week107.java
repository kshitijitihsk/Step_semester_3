public class Main {

    public static int secondHighest(int[] scores) {
        int highest = -1;
        int second  = -1;

        for (int score : scores) {
            if (score > highest) {
                second  = highest;   // old highest becomes second
                highest = score;
            } else if (score < highest && score > second) {
                second = score;      // new distinct runner-up
            }
            // score == highest or score <= second → ignore
        }

        return second;               // -1 if no distinct second exists
    }

    public static void main(String[] args) {
        System.out.println(secondHighest(new int[]{45, 78, 92, 78, 60})); // 78
        System.out.println(secondHighest(new int[]{50, 50, 50}));         // -1
        System.out.println(secondHighest(new int[]{10, 20}));             // 10
        System.out.println(secondHighest(new int[]{5}));                  // -1
    }
}
