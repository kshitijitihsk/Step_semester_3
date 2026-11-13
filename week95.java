import java.util.*;

abstract class Appliance {
    protected final String type;
    protected final double powerWatts;

    Appliance(String type, double powerWatts) {
        this.type = type;
        this.powerWatts = powerWatts;
    }

    String getType() { return type; }

    final double baseUnits(double hours) {
        return powerWatts * hours / 1000.0;
    }
}

interface SaverMode {
    default double applySaver(double units) {
        return units * 0.75;
    }
}

class Fridge extends Appliance {
    Fridge() { super("FRIDGE", 150.0); }
}

class AC extends Appliance implements SaverMode {
    AC() { super("AC", 1500.0); }
}

class TV extends Appliance {
    TV() { super("TV", 100.0); }
}

class Washer extends Appliance implements SaverMode {
    Washer() { super("WASHER", 500.0); }
}

public class Main {
    static Appliance create(String type) {
        switch (type) {
            case "FRIDGE": return new Fridge();
            case "AC":     return new AC();
            case "TV":     return new TV();
            case "WASHER": return new Washer();
            default: throw new IllegalArgumentException("Unknown appliance: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double totalCost = 0.0;
        StringBuilder out = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String line;
            do {
                line = sc.nextLine().trim();
            } while (line.isEmpty());

            String[] parts = line.split("\\s+");
            String type = parts[0];
            double hours = Double.parseDouble(parts[1]);
            boolean saver = parts.length >= 3 && parts[2].equals("SAVER");

            Appliance app = create(type);

            if (saver && !(app instanceof SaverMode)) {
                out.append(String.format("%s: saver mode not supported%n", app.getType()));
                continue;
            }

            double units = app.baseUnits(hours);
            if (saver) {
                units = ((SaverMode) app).applySaver(units);
            }

            double cost = units * 8.0;
            totalCost += cost;

            out.append(String.format(Locale.US,
                    "%s: Units=%.2f Cost=%.2f%n",
                    app.getType(), units, cost));
        }

        out.append(String.format(Locale.US, "Total Cost: %.2f%n", totalCost));
        System.out.print(out);
    }
}
