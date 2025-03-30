import java.util.Scanner;
import java.util.Arrays;

public class SortedArray {

    //  Method to read integers from the user
    public static int[] getIntegers(int capacity) {
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[capacity];

        System.out.println("Enter " + capacity + " integer values:");

        for (int i = 0; i < array.length; i++) {
            while (!scanner.hasNextInt()) {   // Validate input
                System.out.println("Invalid input. Please enter an integer:");
                scanner.next();
            }
            array[i] = scanner.nextInt();
        }
        scanner.close();
        return array;
    }

    // Method to print the array
    public static void printArray(int[] array) {
        System.out.println(Arrays.toString(array));
    }

    // Method to sort the array in descending order
    public static int[] sortIntegers(int[] array) {

        // Use Arrays.copyOf() to avoid modifying the original array
        int[] sortedArray = Arrays.copyOf(array, array.length);

        // Optimized Bubble Sort
        for (int i = 0; i < sortedArray.length - 1; i++) {
            boolean swapped = false;

            for (int j = 0; j < sortedArray.length - 1 - i; j++) {
                if (sortedArray[j] < sortedArray[j + 1]) {
                    // Swap elements
                    int temp = sortedArray[j];
                    sortedArray[j] = sortedArray[j + 1];
                    sortedArray[j + 1] = temp;
                    swapped = true;
                }
            }

            // Early exit if no swaps in this pass
            if (!swapped) {
                break;
            }
        }
        return sortedArray;
    }

    //  Main method to test the program
    public static void main(String[] args) {

        // Read and sort the array
        int[] myArray = getIntegers(5);

        System.out.println("\nOriginal Array:");
        printArray(myArray);

        int[] sortedArray = sortIntegers(myArray);

        System.out.println("\nSorted Array (Descending):");
        printArray(sortedArray);
    }
}
