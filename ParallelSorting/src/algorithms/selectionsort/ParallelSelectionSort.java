package algorithms.selectionsort;

import algorithms.SortingAlgorithm;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ParallelSelectionSort implements SortingAlgorithm {
    private static void swap(int[] arr, int start, int end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }

    private static void edgeCaseLength2(int[] arr){
        if(arr[0] > arr[1]) {
            ParallelSelectionSort.swap(arr, 0, 1);
        }
    }

    @Override
    public void sort(int[] array) {
        int arrayLength = array.length;
        int lastIndex = arrayLength - 1;

        if(arrayLength <= 1) {
            return;
        }

        if(arrayLength == 2) {
            edgeCaseLength2(array);
            return;
        }

        FindLocalMin leftLocalMin = new FindLocalMin();
        FindLocalMin rightLocalMin = new FindLocalMin();

        // Create a thread pool with 2 threads
        ExecutorService executor = Executors.newFixedThreadPool(2);


        int minIndex = 0;
        for (int i = 0; i < arrayLength; i++) {
            int middleIndex = i + 1 + ((lastIndex - i - 1) / 2);

            if(i == lastIndex - 1){
                if(array[i] > array[minIndex]) {
                    ParallelSelectionSort.swap(array, i, minIndex);
                }
                break;
            }

            leftLocalMin.config(array, i + 1, middleIndex - 1);
            rightLocalMin.config(array, middleIndex, lastIndex);

            // Submit tasks to the thread pool
            Future<?> leftFuture = executor.submit(leftLocalMin);
            Future<?> rightFuture = executor.submit(rightLocalMin);

            try {
                // Wait for both tasks to complete
                leftFuture.get();
                rightFuture.get();

                int minLeft = leftLocalMin.getMinIndex();
                int minRight = rightLocalMin.getMinIndex();

                if(array[minLeft] < array[minRight]) {
                    minIndex = minLeft;
                } else {
                    minIndex = minRight;
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

            if(array[i] > array[minIndex]) {
                ParallelSelectionSort.swap(array, i, minIndex);
            }
        }

        // Shutdown the executor when done
        executor.shutdown();
    }

    @Override
    public void sort(String[] args) {

    }

    @Override
    public void export() {

    }
}
