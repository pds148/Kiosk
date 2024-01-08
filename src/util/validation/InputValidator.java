package util.validation;

import java.util.Scanner;

public class InputValidator {
    private static Scanner sc = new Scanner(System.in);

    public static void printLine() {
        System.out.println("--------------------------------------------------------");
    }

    public static int getValidInput(int minValue, int maxValue) {
        int input;
        do {
            printLine();
            System.out.println("[ 유효한 입력을 받습니다. ]");
            System.out.println("범위(" + minValue + " ~ " + maxValue + ") 내의 정수를 입력하세요: ");
            while (!sc.hasNextInt()) {
                sc.nextLine(); // Consume invalid input
                System.out.println("[ 숫자를 입력하세요. ]");
                System.out.println("다시 입력하세요: ");
            }
            input = sc.nextInt();
            sc.nextLine(); // Consume the newline character left in the buffer
        } while (input < minValue || input > maxValue);

        return input;
    }

    public static void closeScanner() {
        sc.close();
    }
}
