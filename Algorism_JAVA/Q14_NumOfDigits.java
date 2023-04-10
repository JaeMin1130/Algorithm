import java.util.Scanner;

public class Q14_NumOfDigits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("수를 입력하세요.");
        int num = scanner.nextInt();
        int[] arr = new int[10];

        // 내 답
        while (true) {
            arr[num % 10] += 1;
            num = num / 10;
            if (num < 10) {
                arr[num] += 1;
                break;
            }
        }

        // 선생님 답
        while (num > 0) {
            arr[num % 10]++;
            num /= 10;
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(i + ": " + arr[i]);
        }
        scanner.close();
    }
}