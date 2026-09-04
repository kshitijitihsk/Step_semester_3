public class LibraryIsbnValidator {

    // Trims whitespace and uppercases only the first 3 characters (publisher code)
    static String normalizeCode(String raw) {
        String trimmed = raw.trim();

        if (trimmed.length() < 3) {
            return trimmed.toUpperCase();
        }

        String publisherCode = trimmed.substring(0, 3).toUpperCase();
        String rest = trimmed.substring(3);

        return publisherCode + rest;
    }

    // Validates a normalized code and builds a formatted display line, or returns the specific error
    static String validateAndFormat(String code) {
        if (code.length() != 13) {
            return "Invalid: code must be exactly 13 characters";
        }

        // First 3 characters must be letters
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(code.charAt(i))) {
                return "Invalid: publisher code must be 3 letters";
            }
        }

        // Remaining 10 characters must be digits
        for (int i = 3; i < 13; i++) {
            if (!Character.isDigit(code.charAt(i))) {
                return "Invalid: remaining 10 characters must be digits";
            }
        }

        String publisherCode = code.substring(0, 3);
        String year = code.substring(3, 7);
        String catalog = code.substring(7, 13);

        StringBuilder display = new StringBuilder();
        display.append("[").append(publisherCode).append("] YEAR: ").append(year)
                .append(" | CATALOG: ").append(catalog);

        return display.toString();
    }

    public static void main(String[] args) {
        String[] testCodes = {
                " pen2026004251 ",
                "12N2026004251",
                "PEN20260042",
                "penAB26004251"
        };

        for (String raw : testCodes) {
            String normalized = normalizeCode(raw);
            String result = validateAndFormat(normalized);
            System.out.println("Input: \"" + raw + "\" -> " + result);
        }
    }
}
