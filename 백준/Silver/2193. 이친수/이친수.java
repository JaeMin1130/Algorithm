import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        Long[] memo = new Long[91];
        memo[1] = memo[2] = 1L;
        for (int i = 3; i < memo.length; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        System.out.println(memo[N]);
    }
}