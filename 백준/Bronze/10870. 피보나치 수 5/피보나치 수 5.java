import java.util.Scanner;

public class Main {
    public static int fibo(int n) {
        if (n >= 2)
            return fibo(n - 1) + fibo(n - 2);
        else if (n == 1)
            return 1;
        else
            return 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        System.out.println(fibo(num));
        scanner.close();
    }
}