import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        StringBuilder temp = new StringBuilder(input[0]).reverse();
        char[] num = temp.toString().toCharArray();

        int base = Integer.parseInt(input[1]);
        int result = 0;

        for (int i = 0; i < num.length; i++) {
            if (num[i] >= 65) {
                result += (num[i] - 55) * Math.pow(base, i);
            } else {
                result += (num[i] - 48) * Math.pow(base, i);
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(result));
        bw.close();
    }
}