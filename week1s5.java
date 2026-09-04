public class ReverseCustomerName {

    // Reverses the given customer name without modifying the original
    static String reverseCustomerName(String customerName) {
        char[] chars = customerName.toCharArray();
        int left = 0, right = chars.length - 1;

        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }

        return new String(chars);
    }

    public static void main(String[] args) {
        String[] customerNames = {"Sunil", "Priya", "Rahul Kumar"};

        for (String name : customerNames) {
            String reversed = reverseCustomerName(name);
            System.out.println("Original Name: " + name);
            System.out.println("Reversed Name: " + reversed);
            System.out.println();
        }
    }
}
