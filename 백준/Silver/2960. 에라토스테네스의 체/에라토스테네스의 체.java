import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        boolean[] isPrime = new boolean[N + 1];
        Arrays.fill(isPrime, true);

        int count = 0;
        for (int i = 2; i < isPrime.length; i++) {
            if (isPrime[i]) {
                isPrime[i] = false;
                count++;
                if (count == K) {
                    System.out.println(i);
                    break;
                }
                for (int j = i * i; j < isPrime.length; j += i) {
                    if (isPrime[j]) {
                        isPrime[j] = false;
                        count++;
                        if (count == K) {
                            System.out.println(j);
                            break;
                        }
                    }
                }
            }
        }
    }
}