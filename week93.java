import java.util.*;

abstract class Student {
    protected final String name;

    // Common transport rule, written once
    protected static final double TRANSPORT_FEE = 12000.0;

    Student(String name) {
        this.name = name;
    }

    String getName() { return name; }

    protected abstract double tuition();

    protected boolean usesBus() {
        return false;
    }

    final double totalFee() {
        double fee = tuition();
        if (usesBus()) {
            fee += TRANSPORT_FEE;
        }
        return fee;
    }
}

class DayScholar extends Student {
    DayScholar(String name) { super(name); }

    @Override protected double tuition() { return 40000.0; }

    @Override protected boolean usesBus() { return true; }
}

class Hosteller extends Student {
    Hosteller(String name) { super(name); }

    @Override protected double tuition() {
        return 40000.0 + 60000.0;
    }
}

class Scholar extends Student {
    Scholar(String name) { super(name); }

    @Override protected double tuition() { return 20000.0; }

    @Override protected boolean usesBus() { return true; }
}

public class Main {
    static Student create(String type, String name) {
        switch (type) {
            case "DAY_SCHOLAR": return new DayScholar(name);
            case "HOSTELLER":   return new Hosteller(name);
            case "SCHOLAR":     return new Scholar(name);
            default: throw new IllegalArgumentException("Unknown student type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double totalCollected = 0.0;
        StringBuilder out = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();

            Student s = create(type, name);
            double fee = s.totalFee();
            totalCollected += fee;

            out.append(String.format(Locale.US, "%s: %.2f%n", s.getName(), fee));
        }

        out.append(String.format(Locale.US, "Total Collected: %.2f%n", totalCollected));
        System.out.print(out);
    }
}
