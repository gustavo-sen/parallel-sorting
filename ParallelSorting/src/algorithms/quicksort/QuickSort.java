package algorithms.quicksort;

public class QuickSort {

    public static void quickSort(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        recQuick(array, 0, array.length - 1);
    }

    private static void recQuick(int[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(array, low, high);
            recQuick(array, low, pivotIndex - 1);
            recQuick(array, pivotIndex, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
