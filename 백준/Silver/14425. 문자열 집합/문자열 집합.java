import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        String[] input = new String[N];
        for (int i = 0; i < input.length; i++) {
            input[i] = br.readLine();
        }

        int count = 0;

        for (int i = 0; i < M; i++) {
            String target = br.readLine();
            for (String string : input) {
                if (target.equals(string)) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}