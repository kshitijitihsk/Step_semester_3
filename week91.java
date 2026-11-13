import java.util.*;

abstract class Seat {
    private final String type;
    private final int count;

    // Common rule: written once
    protected static final double CONVENIENCE_FEE = 20.0;

    Seat(String type, int count) {
        this.type = type;
        this.count = count;
    }

    String getType() { return type; }
    int getCount() { return count; }

    protected abstract double pricePerTicket();

    final double amount() {
        return count * (pricePerTicket() + CONVENIENCE_FEE);
    }
}

class RegularSeat extends Seat {
    RegularSeat(int count) { super("REGULAR", count); }
    @Override protected double pricePerTicket() { return 150.0; }
}

class PremiumSeat extends Seat {
    PremiumSeat(int count) { super("PREMIUM", count); }
    @Override protected double pricePerTicket() { return 250.0; }
}

class ReclinerSeat extends Seat {
    ReclinerSeat(int count) { super("RECLINER", count); }
    @Override protected double pricePerTicket() { return 400.0; }
}

public class Main {
    static Seat create(String type, int count) {
        switch (type) {
            case "REGULAR":  return new RegularSeat(count);
            case "PREMIUM":  return new PremiumSeat(count);
            case "RECLINER": return new ReclinerSeat(count);
            default: throw new IllegalArgumentException("Unknown seat type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0.0;
        StringBuilder out = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int count = sc.nextInt();
            Seat seat = create(type, count);
            double amt = seat.amount();
            total += amt;
            out.append(String.format(Locale.US, "%s: %.2f%n", seat.getType(), amt));
        }

        out.append(String.format(Locale.US, "Total: %.2f%n", total));
        System.out.print(out);
    }
}
