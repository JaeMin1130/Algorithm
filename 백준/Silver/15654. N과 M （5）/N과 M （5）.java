import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class Main {
    static int N, M;
    static int[] arr;
    static int[] input;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        input = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();

        getArr(0);
    }

    private static void getArr(int idx) {
        if (idx == M) {
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < M; i++) {
                if (!set.add(arr[i])) {
                    return;
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int i : arr) {
                sb.append(i + " ");
            }
            System.out.println(sb.toString().trim());
            return;
        }

        for (int i = 0; i < N; i++) {
            arr[idx] = input[i];
            getArr(idx + 1);
        }
    }
}