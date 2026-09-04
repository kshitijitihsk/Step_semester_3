public class AtmPinValidator {

    // Checks whether a PIN is exactly 4 digits long
    static void checkPinLength(String pin) {
        if (pin.length() != 4) {
            System.out.println("Invalid PIN — must be exactly 4 digits.");
        } else {
            System.out.println("PIN length OK.");
        }
    }

    public static void main(String[] args) {
        String[] testPins = {"482", "4820", "12345", "0000"};

        for (String pin : testPins) {
            System.out.print("Input: \"" + pin + "\" -> ");
            checkPinLength(pin);
        }
    }
}
