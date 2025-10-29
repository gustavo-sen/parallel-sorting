package algorithms.countingsort;

import algorithms.SortingAlgorithm;


public class SerialCountingSort implements SortingAlgorithm {

    @Override
    public void sort(int[] array) {
        int n = array.length;
        if (n <= 1) return;
        if (n == 2) { // small fast-path
            if (array[0] > array[1]) {
                int t = array[0]; array[0] = array[1]; array[1] = t;
            }
            return;
        }

        int min = array[0];
        int max = array[0];
        for (int i = 1; i < n; i++) {
            int v = array[i];
            if (v < min) min = v;
            if (v > max) max = v;
        }

        int range = max - min + 1;
        if (range <= 1) return;

        int[] count = new int[range];

        for (int v : array) {
            count[v - min]++;
        }

        int idx = 0;
        for (int i = 0; i < range; i++) {
            int c = count[i];
            int val = i + min;
            while (c-- > 0) {
                array[idx++] = val;
            }
        }
    }

    @Override
    public void sort(String[] args) { }

    @Override
    public void export() { }
}
