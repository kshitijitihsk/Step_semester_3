public class Main {

    /**
     * Returns {rowIndex, totalStudents} for the row with the largest sum.
     * Ties are broken by the smaller row index (because we update only
     * when the new sum is strictly greater).
     */
    public static int[] busiestRow(int[][] grid) {
        int bestRow = 0;
        int bestTotal = -1;

        for (int i = 0; i < grid.length; i++) {
            int sum = 0;
            for (int j = 0; j < grid[i].length; j++) {
                sum += grid[i][j];
            }

            // strictly greater → keeps the earlier row on a tie
            if (sum > bestTotal) {
                bestTotal = sum;
                bestRow = i;
            }
        }

        return new int[]{bestRow, bestTotal};
    }

    public static void main(String[] args) {
        int[][] grid = {
            {2, 0, 1},
            {3, 3, 1},
            {1, 1, 1}
        };

        int[] result = busiestRow(grid);
        System.out.println("Row " + result[0] + ", Total " + result[1]);
    }
}
