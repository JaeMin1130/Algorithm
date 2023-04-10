import java.util.Scanner;

public class Q12_Matrix3 {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("수를 입력하세요.");
        int num = scanner.nextInt();
        int[][] arr = new int[num][num];
        int k = 1;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                arr[j][i] = k++;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
        scanner.close();
    }
}