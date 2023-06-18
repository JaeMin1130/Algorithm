import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Map<String, Integer> map = new HashMap<>();

        int N = Integer.parseInt(br.readLine());
        String[] input_N = br.readLine().split(" ");
        for (String i : input_N) {
            map.computeIfPresent(i, (k, v) -> v + 1);
            map.putIfAbsent(i, 1);
        }

        int M = Integer.parseInt(br.readLine());
        String[] input_M = br.readLine().split(" ");
        for (String i : input_M) {
            bw.write(String.valueOf(map.getOrDefault(i, 0)) + " ");
        }
        bw.flush();
        bw.close();
    }
}