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
        for (int i = 0; i < N; i++) {
            if (!map.keySet().contains(input_N[i])) {
                map.put(input_N[i], 1);
            } else {
                int val = map.get(input_N[i]);
                map.put(input_N[i], ++val);
            }
        }

        int M = Integer.parseInt(br.readLine());
        String[] input_M = br.readLine().split(" ");
        for (int i = 0; i < M; i++) {
            if (!map.keySet().contains(input_M[i])) {
                bw.write("0 ");
            } else {
                int val = map.get(input_M[i]);
                bw.write(String.valueOf(val) + " ");
            }
        }
        bw.close();
    }
}