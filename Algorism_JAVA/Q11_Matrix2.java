import java.util.Scanner;

public class Q11_Matrix2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("수를 입력하세요.");
        int num = scanner.nextInt();
        int[][] array = new int[num][num];

        for (int i = 0, k = 1; i < array.length; i++) {
            // 짝수행은 순행
            if (i % 2 == 0) {
                for (int j = 0; j < array.length; j++) {
                    array[i][j] = k++;
                }
            }
            // 홀수행은 역행
            else if (i % 2 != 0) {
                for (int j = num - 1; j >= 0; j--) {
                    array[i][j] = k++;
                }
            }
        }
        // 출력
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }
        scanner.close();
    }
}