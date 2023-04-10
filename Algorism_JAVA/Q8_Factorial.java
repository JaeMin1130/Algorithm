import java.util.Scanner;

public class Q8_Factorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("수를 입력하세요.");
        int num = scanner.nextInt();
        int factorial = 1;
        for (int i = 1; i <= num; i++) {
            factorial *= i;
        }
        scanner.close();
        System.out.println(num + "! = " + factorial);
    }
}