import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class Main {
    static int N, M;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        getArr(0);
        System.out.println(sb);
    }

    private static void getArr(int idx) throws IOException {
        if (idx == M) {
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < M; i++) {
                if (!set.add(arr[i])) {
                    return;
                }
            }
            for (int i : arr) {
                sb.append(i + " ");
            }
            sb.append("\n");
            return;
        }

        for (int num = 1; num <= N; num++) {
            arr[idx] = num;
            getArr(idx + 1);
        }
    }
}