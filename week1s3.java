import java.util.Random;

public class BMICalculator {

    // Classifies BMI into a health status category
    static String getBmiStatus(double bmi) {
        if (bmi < 18.5) return "Underweight";
        else if (bmi < 25.0) return "Normal";
        else if (bmi < 30.0) return "Overweight";
        else return "Obese";
    }

    // Prints a formatted wellness report table for the whole team
    static void printWellnessReport(double[] heights, double[] weights) {
        System.out.printf("%-10s %-12s %-12s %-8s %-12s%n", "Person", "Height (m)", "Weight (kg)", "BMI", "Status");
        for (int i = 0; i < heights.length; i++) {
            double bmi = weights[i] / (heights[i] * heights[i]);
            String status = getBmiStatus(bmi);
            System.out.printf("%-10s %-12.2f %-12.1f %-8.2f %-12s%n",
                    "Person " + (i + 1), heights[i], weights[i], bmi, status);
        }
    }

    public static void main(String[] args) {
        int teamSize = 10;
        double[] heights = new double[teamSize];
        double[] weights = new double[teamSize];

        Random rand = new Random();
        for (int i = 0; i < teamSize; i++) {
            heights[i] = 1.50 + rand.nextDouble() * 0.40; // 1.50m - 1.90m
            weights[i] = 50 + rand.nextDouble() * 50;      // 50kg - 100kg
        }

        System.out.println("=== Corporate Wellness Report ===");
        printWellnessReport(heights, weights);
    }
}
