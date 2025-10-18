package algorithms.quicksort;

public class QuickSort {
    private static int[] array;
    private static int low;
    private static int high;

    QuickSort(int[] array, int low, int high) {
        QuickSort.array = array;
        QuickSort.low = low;
        QuickSort.high = high;
    }

    public static void sort(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        QuickSort quick = new QuickSort(array, 0, array.length - 1);
        recQuick(array, 0, array.length - 1);
    }

    private static void recQuick(int[] array, int low, int high){
        if (low > high) return;

        int pivotIndex = partition(array, low, high);

        recQuick(array, low, pivotIndex - 1);

        recQuick(array, pivotIndex + 1, high);

    }

    private static int partition(int[] arr, int low, int high) {
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

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
