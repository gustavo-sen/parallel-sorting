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

    static final int SIZE = 100_000_000;
    static int[] data = new int[SIZE];

    public static void main(String[] args) {
        System.out.println("==== Quick Sort ====");

        genRandomData();

        System.out.println("-- QuickSort paralelo --");
        startTimer();
        QuickSortParallel.sort(data);
        stopTimer();
        System.out.println("-- QuickSort Sequencial --");
        startTimer();
        quickSort(data);
        stopTimer();

        System.out.println("==== Merge Sort ====");
        startTimer();
        System.out.println("-- MergeSort paralelo --");
        mergeSortParallel(data);
        stopTimer();
        startTimer();
        System.out.println("-- MergeSort Sequencial --");
        mergeSort(data);
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