import java.util.*;

abstract class Customer {
    private final String type;
    Customer(String type) { this.type = type; }
    String getType() { return type; }
    abstract double finalAmount(double bill);
}

class Student extends Customer {
    Student() { super("STUDENT"); }
    @Override double finalAmount(double bill) { return bill * 0.90; }
}

class Staff extends Customer {
    Staff() { super("STAFF"); }
    @Override double finalAmount(double bill) { return bill * 0.95; }
}

class Guest extends Customer {
    Guest() { super("GUEST"); }
    @Override double finalAmount(double bill) { return bill + 10.0; }
}

public class Main {
    static Customer create(String type) {
        switch (type) {
            case "STUDENT": return new Student();
            case "STAFF":   return new Staff();
            case "GUEST":   return new Guest();
            default: throw new IllegalArgumentException("Unknown type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0.0;
        StringBuilder out = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amount = sc.nextDouble();
            Customer c = create(type);
            double finalAmt = c.finalAmount(amount);
            total += finalAmt;
            out.append(String.format(Locale.US, "%s: %.2f%n", c.getType(), finalAmt));
        }
        out.append(String.format(Locale.US, "Total: %.2f%n", total));
        System.out.print(out);
    }
}
