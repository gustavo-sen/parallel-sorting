import algorithms.quicksort.QuickSortParallel;

import java.util.Scanner;

public class Main {
    static long startTime = 0;
    static long endTime = 0;

    public static void main(String[] args) {
        int testCase = 0;
        System.out.println("Algoritimos");
        System.out.println("Quick Sort - 0");
        Scanner sc = new Scanner(System.in);
        testCase = sc.nextInt();

        QuickSortParallel qs = new QuickSortParallel();

        int arr[] = {2, 1, 3, 4, 5, 6, 9};

        switch (testCase){
            case 0:
                startTimer();
                qs.sort(arr);
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
}