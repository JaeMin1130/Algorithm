import java.util.Scanner;

public class Q06_GCD {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("첫 번째 수를 입력하세요");
        int no1 = scanner.nextInt();
        System.out.println("두 번째 수를 입력하세요");
        int no2 = scanner.nextInt();

        int big, small;
        if (no1 > no2) {
            small = no2;
            big = no1;
        } else {
            small = no1;
            big = no2;
        }

        int gcd = 1;
        for (int i = 1; i <= small; i++) {
            if (big % i == 0 && small % i == 0) {
                gcd = i;
            }
        }
        System.out.println("두 수의 최대공약수: " + gcd);
        scanner.close();
    }
}