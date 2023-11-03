import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer input = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(input.nextToken());
            int M = Integer.parseInt(input.nextToken());
            Map<Integer, ArrayList<Integer>> map = new HashMap<>();
            for (int j = 0; j < M; j++) {
                int[] link = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                map.computeIfPresent(link[0], (k, v) -> {
                    ArrayList<Integer> list = map.get(k);
                    list.add(link[1]);
                    return list;
                });
                map.computeIfPresent(link[1], (k, v) -> {
                    ArrayList<Integer> list = map.get(k);
                    list.add(link[0]);
                    return list;
                });
                map.putIfAbsent(link[0], new ArrayList<Integer>(Arrays.asList(link[1])));
                map.putIfAbsent(link[1], new ArrayList<Integer>(Arrays.asList(link[0])));

            }
            boolean[] isVisited = new boolean[N + 1];
            PriorityQueue<Integer> countQue = new PriorityQueue<>((v1, v2) -> v2 - v1);
            for (int k = 1; k <= N; k++) {
                int count = 0;
                Queue<Integer> q = new LinkedList<>(Arrays.asList(k));
                isVisited[k] = true;
                while (!q.isEmpty()) {
                    int carrier = q.poll();
                    ArrayList<Integer> nextCarriers = map.get(carrier);
                    if (nextCarriers == null) {
                        break;
                    } else {
                        for (int l = 0; l < nextCarriers.size(); l++) {
                            int nextCarrier = nextCarriers.get(l);
                            if (!isVisited[nextCarrier]) {
                                count++;
                                q.add(nextCarrier);
                                isVisited[nextCarrier] = true;
                            }
                        }
                    }
                }
                countQue.add(count);
            }
            System.out.println(countQue.peek());
        }
    }
}