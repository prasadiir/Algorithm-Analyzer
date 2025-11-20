package Analyzer;

import java.util.Random;
import java.util.Arrays;

public class BinarySearch {

    private static int[] randomArray(int n, long seed) {
        Random r = new Random(seed);
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = r.nextInt(10000);
        }
        return a;
    }

    // Manual Binary Search
    private static int binarySearch(int[] a, int key) {
        int left = 0;
        int right = a.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (a[mid] == key) return mid;
            if (a[mid] < key) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] sizes = {100, 500, 1000};
        long seed = 12345L;

        System.out.println("Algorithm: Binary Search");
        System.out.println("Input Size | Time (ms)");
        System.out.println("-----------------------");

        for (int n : sizes) {
            int[] arr = randomArray(n, seed);

            Arrays.sort(arr); // array must be sorted
            int key = arr[0]; // guaranteed to exist

            long start = System.nanoTime();
            int index = binarySearch(arr, key);
            long end = System.nanoTime();

            double ms = (end - start) / 1_000_000.0;

            System.out.printf("%-10d | %.6f%n", n, ms);
        }
    }
}
