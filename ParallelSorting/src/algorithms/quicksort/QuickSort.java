package algorithms.quicksort;

public class QuickSort {

    public static void quickSort(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        recQuick(array, 0, array.length - 1, 0);
    }

    private static void recQuick(int[] array, int low, int high, int depth) {
        if (low < high) {
            if (depth > 1000) {
                System.out.println("Rapaz, papocou aqui, vamo ter q parar, deve ta quase todo sorted");
                return;
            }
            int pivotIndex = partition(array, low, high);
            recQuick(array, low, pivotIndex - 1, depth + 1);
            recQuick(array, pivotIndex + 1, high, depth + 1);
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
