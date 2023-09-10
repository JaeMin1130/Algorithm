import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] arr;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        getArr(0, 1);
        bw.flush();
        bw.close();
    }

    private static void getArr(int idx, int num) throws IOException {
        if (idx == M) {
            StringBuilder sb = new StringBuilder();
            for (int i : arr) {
                sb.append(i + " ");
            }
            bw.write(sb.toString().trim() + "\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            arr[idx] = i;
            getArr(idx + 1, i + 1);
        }
    }
}