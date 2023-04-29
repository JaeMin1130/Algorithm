import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();

        int arr[] = new int[1000];
        int index = 0;
        int num = 1;
        while (index < 1000) {
            for (int j = 0; j < num; j++) {
                arr[index++] = num;
                if (index == 1000)
                    break;
            }
            num++;
        }

        int sum = 0;
        for (int i = num1 - 1; i < num2; i++) {
            sum += arr[i];
        }
        System.out.println(sum);
        
        scanner.close();
    }
}