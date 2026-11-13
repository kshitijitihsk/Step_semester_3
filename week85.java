import java.time.LocalDate;
import java.util.*;

abstract class Plan {
    protected final String type;
    Plan(String type) { this.type = type; }
    String getType() { return type; }
    abstract LocalDate renewalDate(LocalDate start);
}

class BasicPlan extends Plan {
    BasicPlan() { super("BASIC"); }
    @Override LocalDate renewalDate(LocalDate start) { return start.plusDays(30); }
}

class StandardPlan extends Plan {
    StandardPlan() { super("STANDARD"); }
    @Override LocalDate renewalDate(LocalDate start) { return start.plusDays(90); }
}

class PremiumPlan extends Plan {
    PremiumPlan() { super("PREMIUM"); }
    @Override LocalDate renewalDate(LocalDate start) { return start.plusDays(365); }
}

public class Main {
    static Plan create(String type) {
        switch (type) {
            case "BASIC":    return new BasicPlan();
            case "STANDARD": return new StandardPlan();
            case "PREMIUM":  return new PremiumPlan();
            default: throw new IllegalArgumentException("Unknown plan: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        StringBuilder out = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String type  = sc.next();
            String name  = sc.next();
            LocalDate start = LocalDate.parse(sc.next());   // format: YYYY-MM-DD
            Plan plan = create(type);
            LocalDate renewal = plan.renewalDate(start);
            out.append(name).append(": ").append(renewal.toString()).append('\n');
        }
        System.out.print(out);
    }
}
