import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        double A = Double.parseDouble(input[0]);
        double B = Double.parseDouble(input[1]);
        int N = Integer.parseInt(input[2]);
        
        int count = 0;
        int result = 0;

        while (count < N) {
            result = (int) (A / B * 10 % 10);
            A = A % B * 10;
            count++;
        }

        bw.write(String.valueOf(result));
        bw.close();
    }
}