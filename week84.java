import java.util.*;

abstract class Employee {
    protected final String name;
    protected final double monthlySalary;

    Employee(String name, double monthlySalary) {
        this.name = name;
        this.monthlySalary = monthlySalary;
    }

    String getName() { return name; }
    abstract double bonus();
}

class FullTime extends Employee {
    FullTime(String name, double salary) { super(name, salary); }
    @Override double bonus() { return monthlySalary * 0.10; }
}

class PartTime extends Employee {
    PartTime(String name, double salary) { super(name, salary); }
    @Override double bonus() { return monthlySalary * 0.05; }
}

class Intern extends Employee {
    Intern(String name, double salary) { super(name, salary); }
    @Override double bonus() { return 2000.0; }
}

public class Main {
    static Employee create(String type, String name, double salary) {
        switch (type) {
            case "FULLTIME": return new FullTime(name, salary);
            case "PARTTIME": return new PartTime(name, salary);
            case "INTERN":   return new Intern(name, salary);
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
            String name = sc.next();
            double salary = sc.nextDouble();
            Employee e = create(type, name, salary);
            double b = e.bonus();
            total += b;
            out.append(String.format(Locale.US, "%s: %.2f%n", e.getName(), b));
        }
        out.append(String.format(Locale.US, "Total Bonus: %.2f%n", total));
        System.out.print(out);
    }
}
