import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine());

        int count = 0;
        int value = 666;
        String result = new String("666");
        while (true) {
            if (result.indexOf("666") != -1) {
                count++;
            }
            result = String.valueOf(++value);
            if (count == num)
                break;
        }
        bw.write(String.valueOf(value - 1));
        bw.close();
    }
}