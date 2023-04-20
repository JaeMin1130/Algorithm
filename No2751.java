import java.util.Scanner;

public class No2751 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        int[] orderedArr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int rank = 1;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] > arr[j]) {
                    rank++;
                    continue;
                }
            }
            orderedArr[rank - 1] = arr[i];
            rank = 1;
        }
        for (int i = 0; i < orderedArr.length; i++) {
            System.out.println(orderedArr[i]);
        }
        scanner.close();
    }
}
