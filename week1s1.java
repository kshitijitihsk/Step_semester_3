import java.util.Random;

public class RockPaperScissors {

    // Determines the result of a single round from the player's perspective
    static String playRound(String playerMove, String computerMove) {
        if (playerMove.equalsIgnoreCase(computerMove)) {
            return "Draw";
        }
        switch (playerMove.toLowerCase()) {
            case "rock":
                return computerMove.equalsIgnoreCase("scissors") ? "Player Wins" : "Computer Wins";
            case "paper":
                return computerMove.equalsIgnoreCase("rock") ? "Player Wins" : "Computer Wins";
            case "scissors":
                return computerMove.equalsIgnoreCase("paper") ? "Player Wins" : "Computer Wins";
            default:
                throw new IllegalArgumentException("Invalid move: " + playerMove);
        }
    }

    public static void main(String[] args) {
        String[] moves = {"Rock", "Paper", "Scissors"};
        Random rand = new Random();

        // Predefined player moves for a live demo (swap with Scanner input if needed)
        String[] playerMoves = {"Rock", "Paper", "Scissors", "Rock", "Paper"};
        int n = playerMoves.length;

        String[] roundResults = new String[n];
        String[] computerMoves = new String[n];

        int wins = 0, losses = 0, draws = 0;

        for (int i = 0; i < n; i++) {
            String computerMove = moves[rand.nextInt(3)];
            String result = playRound(playerMoves[i], computerMove);

            computerMoves[i] = computerMove;
            roundResults[i] = result;

            if (result.equals("Player Wins")) wins++;
            else if (result.equals("Computer Wins")) losses++;
            else draws++;

            System.out.println("Round " + (i + 1) + " — Player: " + playerMoves[i] +
                    ", Computer: " + computerMove + " -> " + result);
        }

        System.out.println("\n=== Summary Table ===");
        System.out.printf("%-8s %-15s %-15s %-15s%n", "Round", "Player Move", "Computer Move", "Result");
        for (int i = 0; i < n; i++) {
            System.out.printf("%-8d %-15s %-15s %-15s%n", (i + 1), playerMoves[i], computerMoves[i], roundResults[i]);
        }

        double winPercent = (wins * 100.0) / n;
        System.out.println("\nWins: " + wins + " | Losses: " + losses + " | Draws: " + draws +
                " | Win % = " + String.format("%.1f", winPercent) + "%");
    }
}
