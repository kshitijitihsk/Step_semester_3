public class Main {

    /** First index i such that scores[i] >= target (or length if none). */
    private static int lowerBound(int[] a, int target) {
        int lo = 0, hi = a.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (a[mid] < target) lo = mid + 1;
            else                 hi = mid;
        }
        return lo;
    }

    /** First index i such that scores[i] > target (or length if none). */
    private static int upperBound(int[] a, int target) {
        int lo = 0, hi = a.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (a[mid] <= target) lo = mid + 1;
            else                  hi = mid;
        }
        return lo;
    }

    public static int countInBand(int[] scores, int low, int high) {
        return upperBound(scores, high) - lowerBound(scores, low);
    }

    public static void main(String[] args) {
        int[] s = {35, 42, 42, 50, 58, 58, 58, 63, 71, 88};
        System.out.println(countInBand(s, 42, 58));   // 6
        System.out.println(countInBand(s, 90, 100));  // 0
        System.out.println(countInBand(s, 58, 58));   // 3 (only the 58s)
    }
}
