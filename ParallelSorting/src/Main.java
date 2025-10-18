import algorithms.quicksort.QuickSortParallel;

import java.util.Random;
import java.util.Scanner;

public class Main {
    static long startTime = 0;
    static long endTime = 0;

    static final int SIZE = 100_000_000;
    static int[] data = new int[SIZE];

    public static void main(String[] args) {
        int testCase = 0;
        System.out.println("Algoritimos");
        System.out.println("Quick Sort - 0");
        Scanner sc = new Scanner(System.in);
        testCase = sc.nextInt();

        genRandomData();

        switch (testCase){
            case 0:
                startTimer();
                QuickSortParallel.sort(data);
                stopTimer();
        }
    }

    public static void startTimer(){
        System.out.println("Iniciando Teste");
        startTime = System.nanoTime();
    }

    public static void stopTimer(){
        endTime = System.nanoTime();
        System.out.println(String.format("Teste Finalizado em ~%d ms", (endTime - startTime)/ 1_000_000));
    }

    public static void genRandomData(){
        System.out.println("Gerando " + SIZE + " números aleatórios...");
        Random random = new Random();
        for (int i = 0; i < SIZE; i++) {
            data[i] = random.nextInt(SIZE);
        }
    }
}