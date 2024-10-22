public class GenericsExample {
    // Generic method to print an array
    public static <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Integer Array
        Integer[] intArray = {1, 2, 3, 4, 5};
        // String Array
        String[] strArray = {"Hello", "World"};

        // Using the generic method to print arrays
        printArray(intArray);
        printArray(strArray);
    }
}
