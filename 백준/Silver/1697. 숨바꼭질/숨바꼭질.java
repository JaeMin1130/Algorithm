import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Main {
    static int start;
    static int end;
    static int[] visited;

    static void chase(int start) {
        Deque<Integer> q = new LinkedList<>(Arrays.asList(start));
        while (!q.isEmpty()) {
            int val = q.poll();
            if (val == end) {
                break;
            } else {
                int[] steps = { val + 1, val - 1, val * 2 };
                for (int step : steps) {
                    if (step >= 0 && step <= 100000 && visited[step] == 0) {
                        q.add(step);
                        visited[step] = visited[val] + 1;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(br.readLine());

        start = Integer.parseInt(input.nextToken());
        end = Integer.parseInt(input.nextToken());
        visited = new int[200001];

        chase(start);
        System.out.println(visited[end]);
    }
}