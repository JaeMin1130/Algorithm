import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        if (N <= 99) {
            System.out.println(N);
        } else {
            int count = 99;
            for (int num = 100; num < N + 1; num++) {
                int[] arr = new int[(int) Math.log10(num) + 1];
                int val = num;
                for (int i = 0; i < arr.length; i++) {
                    arr[i] = val % 10;
                    val /= 10;
                }
                int cd = arr[1] - arr[0];
                boolean flag = true;
                for (int i = 1; i < arr.length - 1; i++) {
                    if (arr[i] + cd != arr[i + 1]) {
                        flag = false;
                        break;
                    }
                }
                if (flag)
                    count++;
            }
            System.out.println(count);
        }
    }
}
