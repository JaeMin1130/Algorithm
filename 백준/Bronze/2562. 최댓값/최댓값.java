import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int arr[] = new int[9];
        int max = 0;
        int order = 1;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] != max) {
                order++;
            } else {
                break;
            }
        }
        System.out.println(max);
        System.out.println(order);
        scanner.close();
    }
}