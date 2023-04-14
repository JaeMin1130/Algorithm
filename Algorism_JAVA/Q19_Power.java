import java.util.Scanner;

public class Q19_Power {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("밑이 될 수를 입력하세요.");
        int base = scanner.nextInt();
        System.out.println("지수가 될 수를 입력하세요.");
        int exponent = scanner.nextInt();
        int power = 1;

        for (int i = 0; i < exponent; i++) {
            power *= base;
        }

        System.out.println(base + "의 " + exponent + " 거듭제곱 = " + power);
    }
}
