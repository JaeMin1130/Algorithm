import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> q = new PriorityQueue<>((v1, v2) -> v2 - v1);
        for (int i = 0; i < N; i++) {
            q.add(Integer.parseInt(br.readLine()));
        }
        while (!q.isEmpty()) {
            bw.write(String.valueOf(q.poll()) + "\n");
        }
        bw.flush();
        bw.close();
    }
}