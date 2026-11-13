public class Main {

    public static String[] rotateRoster(String[] names, long k) {
        int n = names.length;
        int shift = (int) (k % n);           // full turns do nothing
        String[] result = new String[n];

        // element at index i moves to index (i + shift) % n
        for (int i = 0; i < n; i++) {
            result[(i + shift) % n] = names[i];
        }
        return result;
    }

    public static void main(String[] args) {
        String[] a = {"A", "B", "C", "D", "E"};
        System.out.println(java.util.Arrays.toString(rotateRoster(a, 2)));  // [D, E, A, B, C]
        System.out.println(java.util.Arrays.toString(rotateRoster(a, 7)));  // [D, E, A, B, C]
        System.out.println(java.util.Arrays.toString(rotateRoster(a, 0)));  // [A, B, C, D, E]
    }
}
