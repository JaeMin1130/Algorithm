import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<String> q = new PriorityQueue<>((s1, s2) -> {
            if (s1.length() == s2.length()) {
                char[] s1Arr = s1.toCharArray();
                char[] s2Arr = s2.toCharArray();
                int s1Sum = 0;
                int s2Sum = 0;
                for (int i = 0; i < s1Arr.length; i++) {
                    if (s1Arr[i] < 'A') {
                        s1Sum += s1Arr[i] - '0';
                    }
                    if (s2Arr[i] < 'A') {
                        s2Sum += s2Arr[i] - '0';
                    }
                }
                if (s1Sum == s2Sum) {
                    return s1.compareTo(s2);
                }
                return s1Sum - s2Sum;

            }
            return s1.length() - s2.length();

        });
        for (int i = 0; i < N; i++) {
            q.add(br.readLine());
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (!q.isEmpty()) {
            bw.write(q.poll() + "\n");
        }
        bw.flush();
        bw.close();
    }
}