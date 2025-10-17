package algorithms.selectionsort;

import algorithms.SortingAlgorithm;

public class SerialSelectionSort implements SortingAlgorithm {
    @Override
    public void sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
    }

    @Override
    public void sort(String[] args) {}

    @Override
    public void export() {}
}
