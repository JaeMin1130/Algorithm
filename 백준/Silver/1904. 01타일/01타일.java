import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        int[] memo = new int[1000001];
        memo[1] = 1;
        memo[2] = 2;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 3; i <= N; i++) {
            memo[i] = (memo[i - 2] + memo[i - 1]) % 15746;
        }
        System.out.println(memo[N]);
    }
}