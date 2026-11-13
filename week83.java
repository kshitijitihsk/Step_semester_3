import java.util.*;

abstract class Room {
    protected final String type;
    protected final int units;
    Room(String type, int units) { this.type = type; this.units = units; }
    String getType() { return type; }
    abstract double bill();
}

class SingleRoom extends Room {
    SingleRoom(int units) { super("SINGLE", units); }
    @Override double bill() { return units * 8.0; }
}

class SharedRoom extends Room {
    private final int occupants;
    SharedRoom(int units, int occupants) {
        super("SHARED", units);
        this.occupants = occupants;
    }
    @Override double bill() { return (units * 6.0) / occupants; }
}

class ACRoom extends Room {
    ACRoom(int units) { super("AC", units); }
    @Override double bill() { return units * 10.0 + 200.0; }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0.0;
        StringBuilder out = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int units = sc.nextInt();
            Room room;

            if (type.equals("SINGLE")) {
                room = new SingleRoom(units);
            } else if (type.equals("SHARED")) {
                int occupants = sc.nextInt();
                room = new SharedRoom(units, occupants);
            } else { // AC
                room = new ACRoom(units);
            }

            double b = room.bill();
            total += b;
            out.append(String.format(Locale.US, "%s: %.2f%n", room.getType(), b));
        }
        out.append(String.format(Locale.US, "Total: %.2f%n", total));
        System.out.print(out);
    }
}
