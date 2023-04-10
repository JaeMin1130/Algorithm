import java.util.Scanner;

public class Q10_Matrix1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("수를 입력하세요.");
        int num = scanner.nextInt();
        int[][] array = new int[num][num];
        int k = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                array[i][j] = k++;
                System.out.print(array[i][j] + "\t");
            }
            System.out.println("\n");
        }
        scanner.close();
    }
}