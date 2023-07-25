import java.io.IOException;
import java.util.Scanner;

class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int K = scanner.nextInt();

        boolean[] nums = new boolean[N];
        int[] result = new int[N];

        int idx = K - 1;
        nums[idx] = true;
        result[0] = idx + 1;

        for (int i = 1; i < result.length; i++) {
            int count = 0;
            while (count < K) {
                idx++;
                if (idx >= N) {
                    idx -= N;
                }
                if (!nums[idx]) {
                    count++;
                }
            }
            nums[idx] = true;
            result[i] = idx + 1;
        }

        System.out.print("<");
        for (int i = 0; i < result.length; i++) {
            if (i != N - 1) {
                System.out.print(result[i] + ", ");
            } else {
                System.out.print(result[i]);
            }
        }
        System.out.print(">");

        scanner.close();
    }
}