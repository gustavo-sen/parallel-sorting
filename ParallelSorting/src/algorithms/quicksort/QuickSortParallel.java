package algorithms.quicksort;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class QuickSortParallel extends RecursiveAction {

    private int[] array;
    private int low;
    private int high;

    QuickSortParallel(int[] array, int low, int high){
        this.array = array;
        this.low = low;
        this.high = high;
    }

    public static void sort(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }

        QuickSortParallel quickTask = new QuickSortParallel(array, 0, array.length - 1);
        ForkJoinPool pool = ForkJoinPool.commonPool();
        pool.invoke(quickTask);
    }

    @Override
    protected void compute() {
        if (low < high) {

            int pivotIndex = partition(array, low, high);

            QuickSortParallel leftTask = new QuickSortParallel(array, low, pivotIndex - 1);
            QuickSortParallel rightTask = new QuickSortParallel(array, pivotIndex + 1, high);

            invokeAll(leftTask, rightTask);
        }
    }

    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, high);

        return i + 1;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
