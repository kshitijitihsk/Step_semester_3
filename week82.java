import java.util.*;

abstract class Vehicle {
    private final String type;
    Vehicle(String type) { this.type = type; }
    String getType() { return type; }
    abstract double charge(int hours);
}

class Bike extends Vehicle {
    Bike() { super("BIKE"); }
    @Override double charge(int hours) { return 10.0 * hours; }
}

class Car extends Vehicle {
    Car() { super("CAR"); }
    @Override double charge(int hours) { return 30.0 + 20.0 * (hours - 1); }
}

class Truck extends Vehicle {
    Truck() { super("TRUCK"); }
    @Override double charge(int hours) { return Math.max(50.0 * hours, 100.0); }
}

public class Main {
    static Vehicle create(String type) {
        switch (type) {
            case "BIKE":  return new Bike();
            case "CAR":   return new Car();
            case "TRUCK": return new Truck();
            default: throw new IllegalArgumentException("Unknown vehicle: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0.0;
        StringBuilder out = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int hours = sc.nextInt();
            Vehicle v = create(type);
            double c = v.charge(hours);
            total += c;
            out.append(String.format(Locale.US, "%s: %.2f%n", v.getType(), c));
        }
        out.append(String.format(Locale.US, "Total: %.2f%n", total));
        System.out.print(out);
    }
}
