import java.util.*;

abstract class Cab {
    protected final String type;

    // Minimum fare rule, written once
    protected static final double MIN_FARE = 100.0;

    Cab(String type) {
        this.type = type;
    }

    String getType() { return type; }

    protected abstract double ratePerKm();

    final double baseFare(double km) {
        return Math.max(km * ratePerKm(), MIN_FARE);
    }
}

interface NightService {
    default double nightFare(double fare) {
        return fare * 1.20;
    }
}

class Mini extends Cab {
    Mini() { super("MINI"); }
    @Override protected double ratePerKm() { return 10.0; }
}

class Sedan extends Cab implements NightService {
    Sedan() { super("SEDAN"); }
    @Override protected double ratePerKm() { return 14.0; }
}

class SUV extends Cab implements NightService {
    SUV() { super("SUV"); }
    @Override protected double ratePerKm() { return 18.0; }
}

public class Main {
    static Cab create(String type) {
        switch (type) {
            case "MINI":  return new Mini();
            case "SEDAN": return new Sedan();
            case "SUV":   return new SUV();
            default: throw new IllegalArgumentException("Unknown cab type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0.0;
        StringBuilder out = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double km = sc.nextDouble();
            String time = sc.next();

            Cab cab = create(type);

            if (time.equals("NIGHT")) {
                if (cab instanceof NightService) {
                    double fare = ((NightService) cab).nightFare(cab.baseFare(km));
                    total += fare;
                    out.append(String.format(Locale.US, "%s: %.2f%n", cab.getType(), fare));
                } else {
                    out.append(String.format("%s: night service not available%n", cab.getType()));
                }
            } else {
                double fare = cab.baseFare(km);
                total += fare;
                out.append(String.format(Locale.US, "%s: %.2f%n", cab.getType(), fare));
            }
        }

        out.append(String.format(Locale.US, "Total: %.2f%n", total));
        System.out.print(out);
    }
}
