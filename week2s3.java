public class ProductInventoryParser {

    // Parses a CSV line of "ProductName,SKU,Quantity" and prints a formatted record
    static void parseInventoryRecord(String csvLine) {
        String[] fields = csvLine.split(",");

        if (fields.length != 3) {
            System.out.println("Invalid Record");
            return;
        }

        String productName = fields[0].trim();
        String sku = fields[1].trim();
        String quantity = fields[2].trim();

        System.out.println("Product: " + productName + " | SKU: " + sku + " | Qty: " + quantity);
    }

    public static void main(String[] args) {
        String[] testRecords = {
                "Wireless Mouse,WM-2201,150",
                "Wireless Mouse,150",
                "USB Cable,UC-1001,300"
        };

        for (String record : testRecords) {
            System.out.print("Input: \"" + record + "\" -> ");
            parseInventoryRecord(record);
        }
    }
}
