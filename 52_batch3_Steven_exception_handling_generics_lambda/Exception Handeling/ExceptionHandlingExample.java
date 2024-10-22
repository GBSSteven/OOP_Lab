public class ExceptionHandlingExample {
    public static void main(String[] args) {
        try {
            // Attempt to divide by zero
            int result = 10 / 0;
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            // Handle ArithmeticException
            System.out.println("Exception caught: Division by zero is not allowed.");
        } finally {
            // This block will always execute
            System.out.println("Finally block executed.");
        }
    }
}
