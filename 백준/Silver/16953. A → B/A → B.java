import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long A, B;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());

        int result = calculate(A);
        if (result >= 77777) {
            System.out.println(-1);
        } else {
            System.out.println(calculate(A));
        }
    }

    private static int calculate(Long num) {
        if (num > B) {
            return 77777;
        } else if (num == B) {
            return 1;
        } else {
            count = 1 + Math.min(calculate(num * 2), calculate(num * 10 + 1));
            return count;
        }
    }
}