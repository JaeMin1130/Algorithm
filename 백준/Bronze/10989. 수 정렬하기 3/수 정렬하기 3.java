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
        int list[] = new int[1000001];
        for (int i = 0; i < num; i++) {
            int value = Integer.parseInt(br.readLine());
            list[value] += 1;
        }

        for (int i = 1; i < list.length; i++) {
            if (list[i] != 0) {
                for (int j = 0; j < list[i]; j++) {
                    bw.write(String.valueOf(i) + "\n");
                }
            }
        }
        bw.close();
    }
}