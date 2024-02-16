import java.util.Random;
import java.time.Duration;
import java.time.Instant;

public class CombinedInsertionSort {
    public static void sort(int[] arr) {
        int n = arr.length;
        // Move smallest element to the front
        for (int i = 1; i < n; i++) {
            if (arr[i] < arr[i - 1]) {
                int temp = arr[i];
                arr[i] = arr[i - 1];
                arr[i - 1] = temp;
            }
        }
        // Insert two elements at a time
        for (int i = 2; i < n; ++i) {
            int key1 = arr[i - 2];
            int key2 = arr[i - 1];
            int j = i - 2;

            while (j >= 0 && arr[j] > key2) {
                arr[j + 2] = arr[j];
                arr[j + 1] = key1;
                arr[j] = key2;
                j = j - 1;
                if (j >= 0) {
                    key1 = arr[j];
                }
            }
        }
    }

    public static void main(String[] args) {
        Random random = new Random();
        int n = 80000; // Set the number of elements in the array
        int[] arr = new int[n];

        // Generate random data
        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt();
        }

        // Start time measurement
        Instant start = Instant.now();

        // Perform combined modified insertion sort
        sort(arr);

        // End time measurement
        Instant end = Instant.now();

        // Calculate the elapsed time
        Duration duration = Duration.between(start, end);
        System.out.println("Elapsed time for combined modified insertion sort: " + duration.toMillis() + " milliseconds");
    }
}
