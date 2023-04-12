import java.util.Scanner;

public class Q16_Star1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("수를 입력하세요.");
        int num = scanner.nextInt();
        String star = "*";

        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(star);
            }
            System.out.println();
        }
    }
}
