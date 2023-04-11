import java.util.Scanner;

public class Q15_TimesTable {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("출력할 구구단의 시작 단수를 입력하세요.");
        int startNum = scanner.nextInt();
        System.out.println("출력할 구구단의 끝 단수를 입력하세요.");
        int endNum = scanner.nextInt();

        for (int i = 1; i <= 9; i++) {
            for (int j = startNum; j <= endNum; j++) {
             // System.out.print(j + " * " + i + " = " + (i * j) + "\t");
                System.out.printf("%2d *%2d =%3d" + "\t", j, i, (i * j));
            }
            System.out.println();
        }
        scanner.close();
    }
}
