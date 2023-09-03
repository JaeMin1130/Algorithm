import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class Main {
    static int N, M;
    static int[] arr;
    static int[] input;
    static Set<String> result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        input = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
        result = new HashSet<>();
        getArr(0, 0);

        List<String> sortedResult = new ArrayList<>(result);
        Collections.sort(sortedResult, (s1, s2) -> {
            String[] tokens1 = s1.split(" ");
            String[] tokens2 = s2.split(" ");

            for (int i = 0; i < Math.min(tokens1.length, tokens2.length); i++) {
                int num1 = Integer.parseInt(tokens1[i]);
                int num2 = Integer.parseInt(tokens2[i]);

                if (num1 != num2) {
                    return num1 - num2;
                }
            }

            return tokens1.length - tokens2.length;
        });

        for (String str : sortedResult) {
            System.out.println(str);
        }
    }

    private static void getArr(int idx, int num) {
        if (idx == M) {
            StringBuilder sb = new StringBuilder();
            for (int i : arr) {
                sb.append(i + " ");
            }
            result.add(sb.toString().trim());
            return;
        }

        for (int i = num; i < N; i++) {
            arr[idx] = input[i];
            getArr(idx + 1, i);
        }
    }
}