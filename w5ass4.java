private static double rowAverage(int[] row) {
    int sum = 0;
    for (int over : row) sum += over;
    return (double) sum / row.length;
}

static String classifyMatches(int[][] runsPerOver, int threshold) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < runsPerOver.length; i++) {
        double avg = rowAverage(runsPerOver[i]);
        String label = (avg >= threshold) ? "Power Surge" : "Normal";
        if (i > 0) sb.append(" | ");
        sb.append("Match ").append(i).append(": ").append(label);
    }
    return sb.toString();
}
