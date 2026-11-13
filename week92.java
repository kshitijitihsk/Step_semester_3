import java.util.*;

abstract class Parcel {
    protected final String type;
    protected final double weightKg;
    protected final double declaredValue;

    Parcel(String type, double weightKg, double declaredValue) {
        this.type = type;
        this.weightKg = weightKg;
        this.declaredValue = declaredValue;
    }

    String getType() { return type; }
    abstract double charge();
}

interface Insurable {
    double insurance();
}

class StandardParcel extends Parcel {
    StandardParcel(double weightKg, double declaredValue) {
        super("STANDARD", weightKg, declaredValue);
    }

    @Override double charge() {
        return 40.0 + 10.0 * weightKg;
    }
}

class ExpressParcel extends Parcel implements Insurable {
    ExpressParcel(double weightKg, double declaredValue) {
        super("EXPRESS", weightKg, declaredValue);
    }

    @Override double charge() {
        return 80.0 + 15.0 * weightKg;
    }

    @Override public double insurance() {
        return 0.02 * declaredValue;
    }
}

class FragileParcel extends Parcel implements Insurable {
    FragileParcel(double weightKg, double declaredValue) {
        super("FRAGILE", weightKg, declaredValue);
    }

    @Override double charge() {
        return 40.0 + 10.0 * weightKg + 50.0;
    }

    @Override public double insurance() {
        return 0.02 * declaredValue;
    }
}

public class Main {
    static Parcel create(String type, double weight, double value) {
        switch (type) {
            case "STANDARD": return new StandardParcel(weight, value);
            case "EXPRESS":  return new ExpressParcel(weight, value);
            case "FRAGILE":  return new FragileParcel(weight, value);
            default: throw new IllegalArgumentException("Unknown parcel type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double grandTotal = 0.0;
        StringBuilder out = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double weight = sc.nextDouble();
            double value = sc.nextDouble();

            Parcel p = create(type, weight, value);
            double charge = p.charge();
            double insurance = (p instanceof Insurable)
                    ? ((Insurable) p).insurance()
                    : 0.0;

            double total = charge + insurance;
            grandTotal += total;

            out.append(String.format(Locale.US,
                    "%s: Charge=%.2f Insurance=%.2f Total=%.2f%n",
                    p.getType(), charge, insurance, total));
        }

        out.append(String.format(Locale.US, "Grand Total: %.2f%n", grandTotal));
        System.out.print(out);
    }
}
