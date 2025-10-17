import java.util.Scanner;

public class Main {
    static long startTime = 0;
    static long endTime = 0;

    public static void main(String[] args) {
        int testCase = 0;

        System.out.println("Quick Sort 0");
        Scanner sc = new Scanner(System.in);
        testCase = sc.nextInt();

        switch (testCase){
            case 0:

            default:
                System.out.println("invalido");
        }
    }

    public static void startTimer(){
        System.out.println("Iniciando Teste");
        startTime = System.nanoTime();
    }

    public static void stopTimer(){
        endTime = System.nanoTime();
        System.out.println(String.format("Teste Finalizado %d", (startTime - endTime)));
    }
}