import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Main {
    static int N;
    static int[] arr;
    static int[] ans = new int[6];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            StringTokenizer input = new StringTokenizer(br.readLine());
            N = Integer.parseInt(input.nextToken());
            if (N == 0) {
                break;
            } else {
                arr = new int[N];
                for (int i = 0; i < N; i++) {
                    arr[i] = Integer.parseInt(input.nextToken());
                }
                recur(0, 0, bw);
                bw.write("\n");
            }
        }
        bw.flush();
        bw.close();
    }

    static void recur(int idx, int start, BufferedWriter bw) throws IOException {
        if (idx == 6) {
            for (int i = 0; i < 6; i++) {
                bw.write(ans[i] + " ");
            }
            bw.write("\n");
            return;
        }

        for (int i = start; i < N; i++) {
            ans[idx] = arr[i];
            recur(idx + 1, i + 1, bw);
        }
    }
}