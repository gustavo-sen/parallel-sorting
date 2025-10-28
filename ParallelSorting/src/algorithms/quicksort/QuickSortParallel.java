package algorithms.quicksort;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class QuickSortParallel extends RecursiveAction {

    private int[] array;
    private int lo;
    private int hi;

    QuickSortParallel(int[] array, int lo, int hi){
        this.array = array;
        this.lo = lo;
        this.hi = hi;
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
        if (lo < hi) {
            int pvIndex = partition(array, lo, hi);
            
            QuickSortParallel leftTask = new QuickSortParallel(array, lo, pvIndex - 1);
            QuickSortParallel rightTask = new QuickSortParallel(array, pvIndex + 1, hi);

            // junta return das tasks
            invokeAll(leftTask, rightTask);
        }
    }

    private int partition(int[] arr, int lo, int hi) {
        int pv = arr[hi];
        int i = lo - 1;

        for (int j = lo; j < hi; j++) {
            if (arr[j] <= pv) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, hi);

        return i + 1;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
