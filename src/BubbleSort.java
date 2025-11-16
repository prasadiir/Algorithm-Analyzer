package Analyzer;

import java.util.Random;

public class BubbleSort {

    private static int[] randomArray(int n, long seed) {
        Random r = new Random(seed);
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = r.nextInt(10000);
        }
        return a;
    }

    private static void bubbleSort(int[] a) {
        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] sizes = {100, 500, 1000};
        long seed = 12345L;

        System.out.println("Algorithm: Bubble Sort");
        System.out.println("Input Size | Time (ms)");
        System.out.println("----------------------");

        for (int n : sizes) {
            int[] arr = randomArray(n, seed);

            long start = System.nanoTime();
            bubbleSort(arr);
            long end = System.nanoTime();

            double ms = (end - start) / 1_000_000.0;

            System.out.printf("%-10d | %.4f%n", n, ms);
        }
    }
}
