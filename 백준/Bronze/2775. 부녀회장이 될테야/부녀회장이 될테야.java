import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        int nArr[] = new int[T];
        int kArr[] = new int[T];
        for (int i = 0; i < T; i++) {
            nArr[i] = scanner.nextInt();
            kArr[i] = scanner.nextInt();
        }

        for (int i = 0; i < kArr.length; i++) {
            int n = nArr[i];
            int k = kArr[i];
            int sum = 0;
            int arr[][] = new int[n + 1][k + 1];
            for (int j = 1; j < arr[0].length; j++) {
                arr[0][j] = j;
            }
            for (int j = 1; j < arr.length; j++) {
                for (int m = 1; m < arr[j].length; m++) {
                    sum += arr[j - 1][m];
                    arr[j][m] = sum;
                }
                sum = 0;
            }

            System.out.println(arr[n][k]);
        }

        scanner.close();
    }
}