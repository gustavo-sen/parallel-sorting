package algorithms.selectionsort;

import java.util.Arrays;
import java.util.Random;

/**
 * Utility factory for building deterministic test arrays of various shapes and sizes.
 */
public final class TestArrayFactory {
    private TestArrayFactory() {}

    public static int[] empty() { return new int[0]; }

    public static int[] single() { return new int[]{42}; }

    public static int[] twoSorted() { return new int[]{3, 7}; }

    public static int[] twoUnsorted() { return new int[]{7, 3}; }

    /**
     * Returns a deterministically shuffled array with odd length >= 101.
     */
    public static int[] longOddUnsorted() {
        return deterministicShuffledRange(101); // 101 is odd and >= 100
    }

    /**
     * Returns a deterministically shuffled array with even length >= 100.
     */
    public static int[] longEvenUnsorted() {
        return deterministicShuffledRange(100); // 100 is even
    }

    public static int[] longOddReversed() {
        int n = 101;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = n - i; // descending 101..1
        }
        return arr;
    }

    public static int[] longEvenSorted() {
        int n = 100;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1; // ascending 1..100
        }
        return arr;
    }

    public static int[] longOddSorted() {
        int n = 101;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1; // ascending 1..101
        }
        return arr;
    }

    private static int[] deterministicShuffledRange(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1; // 1..n
        }
        // Fisher-Yates with fixed seed for determinism
        Random rnd = new Random(123456789L + n);
        for (int i = n - 1; i > 0; i--) {
            int j = rnd.nextInt(i + 1);
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
        // Ensure not accidentally sorted already
        if (isSorted(arr)) {
            // simple swap to break order deterministically
            int tmp = arr[0];
            arr[0] = arr[n - 1];
            arr[n - 1] = tmp;
        }
        return arr;
    }

    private static boolean isSorted(int[] a) {
        for (int i = 1; i < a.length; i++) {
            if (a[i - 1] > a[i]) return false;
        }
        return true;
    }

    public static int[] sortedCopy(int[] original) {
        int[] copy = Arrays.copyOf(original, original.length);
        Arrays.sort(copy);
        return copy;
    }
}
