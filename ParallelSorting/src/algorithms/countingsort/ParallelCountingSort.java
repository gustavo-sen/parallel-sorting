package algorithms.countingsort;

import algorithms.SortingAlgorithm;

public class ParallelCountingSort implements SortingAlgorithm {

    @Override
    public void sort(int[] array) {
        int length = array.length;
        if (length <= 1) return;
        if (length == 2) {
            if (array[0] > array[1]) { int t = array[0]; array[0] = array[1]; array[1] = t; }
            return;
        }

        int min = array[0];
        int max = array[0];
        for (int i = 1; i < length; i++) {
            int v = array[i];
            if (v < min) min = v;
            if (v > max) max = v;
        }
        int range = max - min + 1;
        if (range <= 1) return;

        final int[] countA = new int[range];
        final int[] countB = new int[range];

        final int mid = length / 2;
        final int minValue = min;
        final int[] arrRef = array;

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < mid; i++) {
                countA[arrRef[i] - minValue]++;
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = mid; i < length; i++) {
                countB[arrRef[i] - minValue]++;
            }
        });

        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            // single-threaded counting if interrupted
            for (int i = 0; i < length; i++) {
                countA[array[i] - min]++;
            }
            for (int i = 0; i < range; i++) {
                countB[i] = 0;
            }
        }

        int[] combined = new int[range];
        for (int i = 0; i < range; i++) {
            combined[i] = countA[i] + countB[i];
        }
        for (int i = 1; i < range; i++) {
            combined[i] += combined[i - 1];
        }

        int[] output = new int[length];
        for (int i = length - 1; i >= 0; i--) {
            int v = array[i];
            int idx = v - min;
            int pos = --combined[idx];
            output[pos] = v;
        }

        System.arraycopy(output, 0, array, 0, length);
    }

    @Override
    public void sort(String[] args) { }

    @Override
    public void export() { }
}
