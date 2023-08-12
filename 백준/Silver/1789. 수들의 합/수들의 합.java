import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long target = Long.parseLong(br.readLine());
        long num = 1L;
        long sum = 0L;

        while (target >= sum) {
            sum += num++;
        }

        System.out.println(num - 2);
    }
}