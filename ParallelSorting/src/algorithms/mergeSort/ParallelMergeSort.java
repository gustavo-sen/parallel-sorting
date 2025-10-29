package algorithms.mergeSort;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class ParallelMergeSort extends RecursiveAction {

    private final int[] arr;
    private final int le;
    private final int ri;

    public static void mergeSortParallel(int[] arr) {
        ForkJoinPool pool = ForkJoinPool.commonPool();
        pool.invoke(new ParallelMergeSort(arr, 0, arr.length - 1));
    }

    public ParallelMergeSort(int[] arr, int left, int right) {
        this.arr = arr;
        this.le = left;
        this.ri = right;
    }

    @Override
    protected void compute() {
        if (le >= ri) return;

        int mid = (le + ri) / 2;

        ParallelMergeSort leftTask = new ParallelMergeSort(arr, le, mid);
        ParallelMergeSort rightTask = new ParallelMergeSort(arr, mid + 1, ri);

        invokeAll(leftTask, rightTask);
        merge(le, mid, ri);
    }

    private void merge(int left, int mid, int right) {
        int[] temp = new int[right - left + 1];

        int i = left;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= right) {
            temp[k++] = (arr[i] <= arr[j]) ? arr[i++] : arr[j++];
        }

        while (i <= mid) temp[k++] = arr[i++];
        while (j <= right) temp[k++] = arr[j++];

        System.arraycopy(temp, 0, arr, left, temp.length);
    }
}
