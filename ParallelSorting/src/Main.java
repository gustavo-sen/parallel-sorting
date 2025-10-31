import algorithms.mergeSort.MergeSort;
import algorithms.quicksort.QuickSort;
import algorithms.quicksort.QuickSortParallel;
import algorithms.selectionsort.SerialSelectionSort;
import algorithms.selectionsort.ParallelSelectionSort;
import algorithms.countingsort.SerialCountingSort;
import algorithms.countingsort.ParallelCountingSort;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Random;

import static algorithms.mergeSort.MergeSort.mergeSort;
import static algorithms.mergeSort.ParallelMergeSort.mergeSortParallel;
import static algorithms.quicksort.QuickSort.quickSort;

public class Main {
    static long startTime = 0;
    static long endTime = 0;

    static final int SIZE = 1_000_000;
    static final String CSV_FILE = SIZE + "-sample.csv";
    static int[] data = new int[SIZE];

    public static void main(String[] args) {
        genRandomData();
        int[] dataQuickParallel = data.clone();
        int[] dataQuickSeries = data.clone();
        int[] dataMergeParallel = data.clone();
        int[] dataMerge = data.clone();
        int[] dataSelectionParallel = data.clone();
        int[] dataSelectionSerial = data.clone();
        int[] dataCountingParallel = data.clone();
        int[] dataCountingSerial = data.clone();

        System.out.println("==== Quick Sort ====");

        System.out.println();
        System.out.println("-- QuickSort paralelo --");
        startTimer();
        QuickSortParallel.sort(dataQuickParallel);
        System.out.println();
        long tQuickPar = stopTimer();
        writeCsvRow("QuickSort paralelo", tQuickPar, SIZE);

        System.out.println("-- QuickSort Sequencial --");
        startTimer();
        quickSort(dataQuickSeries);
        long tQuickSeq = stopTimer();
        writeCsvRow("QuickSort sequencial", tQuickSeq, SIZE);

        System.out.println("==== Merge Sort ====");
        startTimer();
        System.out.println("-- MergeSort paralelo --");
        mergeSortParallel(dataMergeParallel);
        long tMergePar = stopTimer();
        writeCsvRow("MergeSort paralelo", tMergePar, SIZE);

        startTimer();
        System.out.println("-- MergeSort Sequencial --");
        mergeSort(dataMerge);
        long tMergeSeq = stopTimer();
        writeCsvRow("MergeSort sequencial", tMergeSeq, SIZE);

        System.out.println("==== Selection Sort ====");
        ParallelSelectionSort pSel = new ParallelSelectionSort();
        SerialSelectionSort sSel = new SerialSelectionSort();
        System.out.println("-- SelectionSort paralelo --");
        startTimer();
        pSel.sort(dataSelectionParallel);
        long tSelPar = stopTimer();
        writeCsvRow("SelectionSort paralelo", tSelPar, SIZE);

        System.out.println("-- SelectionSort Sequencial --");
        startTimer();
        sSel.sort(dataSelectionSerial);
        long tSelSeq = stopTimer();
        writeCsvRow("SelectionSort sequencial", tSelSeq, SIZE);

        System.out.println("==== Counting Sort ====");
        ParallelCountingSort pCount = new ParallelCountingSort();
        SerialCountingSort sCount = new SerialCountingSort();
        System.out.println("-- CountingSort paralelo --");
        startTimer();
        pCount.sort(dataCountingParallel);
        long tCountPar = stopTimer();
        writeCsvRow("CountingSort paralelo", tCountPar, SIZE);

        System.out.println("-- CountingSort Sequencial --");
        startTimer();
        sCount.sort(dataCountingSerial);
        long tCountSeq = stopTimer();
        writeCsvRow("CountingSort sequencial", tCountSeq, SIZE);
    }

    public static void startTimer(){
        System.out.println("Iniciando Teste");
        startTime = System.nanoTime();
    }

    public static long stopTimer(){
        endTime = System.nanoTime();
        long elapsedMs = (endTime - startTime) / 1_000_000;
        System.out.printf("Teste Finalizado em ~%d ms \n", elapsedMs);
        return elapsedMs;
    }

    private static void writeCsvRow(String implementationName, long timeMs, int sampleSize) {
        Path path = Path.of(CSV_FILE);
        try {
            if (!Files.exists(path)) {
                String header = "implentation_name,time,sample_size\n";
                Files.write(path, header.getBytes(StandardCharsets.UTF_8));
            }
            String row = implementationName + "," + timeMs + "," + sampleSize + "\n";
            Files.write(path, row.getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.err.println("Erro ao escrever CSV: " + e.getMessage());
        }
    }

    public static void genRandomData(){
        System.out.printf("Gerando %d números aleatórios...", SIZE);
        Random random = new Random();
        for (int i = 0; i < SIZE; i++) {
            data[i] = random.nextInt(SIZE);
        }
    }
}