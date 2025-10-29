import algorithms.mergeSort.MergeSort;
import algorithms.quicksort.QuickSort;
import algorithms.quicksort.QuickSortParallel;

import java.util.Random;

import static algorithms.mergeSort.MergeSort.mergeSort;
import static algorithms.mergeSort.ParallelMergeSort.mergeSortParallel;
import static algorithms.quicksort.QuickSort.quickSort;

public class Main {
    static long startTime = 0;
    static long endTime = 0;

    static final int SIZE = 100_000;
    static int[] data = new int[SIZE];

    public static void main(String[] args) {
        genRandomData();
        int[] dataQuickParallel = data.clone();
        int[] dataQuickSeries = data.clone();
        int[] dataMergeParallel = data.clone();
        int[] dataMerge = data.clone();

        System.out.println("==== Quick Sort ====");

        System.out.println();
        System.out.println("-- QuickSort paralelo --");
        startTimer();
        QuickSortParallel.sort(dataQuickParallel);
        System.out.println();
        stopTimer();
        System.out.println("-- QuickSort Sequencial --");
        startTimer();
        quickSort(dataQuickSeries);
        stopTimer();

        System.out.println("==== Merge Sort ====");
        startTimer();
        System.out.println("-- MergeSort paralelo --");
        mergeSortParallel(dataMergeParallel);
        stopTimer();
        startTimer();
        System.out.println("-- MergeSort Sequencial --");
        mergeSort(dataMerge);
        stopTimer();
    }

    public static void startTimer(){
        System.out.println("Iniciando Teste");
        startTime = System.nanoTime();
    }

    public static void stopTimer(){
        endTime = System.nanoTime();
        System.out.printf("Teste Finalizado em ~%d ms \n", (endTime - startTime)/ 1_000_000);
    }

    public static void genRandomData(){
        System.out.printf("Gerando %d números aleatórios...", SIZE);
        Random random = new Random();
        for (int i = 0; i < SIZE; i++) {
            data[i] = random.nextInt(SIZE);
        }
    }
}