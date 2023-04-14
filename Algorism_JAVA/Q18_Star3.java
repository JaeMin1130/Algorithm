import java.util.Scanner;

public class Q18_Star3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("수를 입력하세요.");
        int num = scanner.nextInt();

        for (int i = 1; i <= num; i++) {
            for (int j = num; j > 0; j--) {
                if (i >= j) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}