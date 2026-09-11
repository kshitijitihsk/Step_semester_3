static class Player implements Comparable<Player> {
    String name;
    int matchesPlayed;
    double battingAverage;
    boolean injured;

    public Player(String name, int matchesPlayed, double battingAverage, boolean injured) {
        this.name = name;
        this.matchesPlayed = matchesPlayed;
        this.battingAverage = battingAverage;
        this.injured = injured;
    }

    static boolean isDraftable(int matchesPlayed) {
        return matchesPlayed >= 10;               // experience-only rule
    }

    static boolean isDraftable(int matchesPlayed, boolean injured) {
        return matchesPlayed >= 5 && !injured;     // combined rule
    }

    @Override
    public int compareTo(Player other) {
        return Double.compare(other.battingAverage, this.battingAverage); // descending
    }
}

static String draftAndRank(Player[] players) {
    Player[] temp = new Player[players.length];
    int count = 0;
    for (Player p : players) {
        if (Player.isDraftable(p.matchesPlayed) || Player.isDraftable(p.matchesPlayed, p.injured)) {
            temp[count++] = p;
        }
    }
    Player[] draftable = Arrays.copyOf(temp, count);
    Arrays.sort(draftable);   // uses compareTo — no manual sort logic

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < draftable.length; i++) {
        if (i > 0) sb.append(" | ");
        sb.append(i + 1).append(". ").append(draftable[i].name);
    }
    return sb.toString();
}
