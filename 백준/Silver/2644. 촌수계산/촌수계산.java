import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] target = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int line = Integer.parseInt(br.readLine());
        Map<Integer, HashSet<Integer>> map = new HashMap<>();
        for (int i = 0; i < line; i++) {
            int[] input = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            map.putIfAbsent(input[0], new HashSet<>(Arrays.asList(input[1])));
            map.putIfAbsent(input[1], new HashSet<>(Arrays.asList(input[0])));
            map.computeIfPresent(input[0], (key, value) -> {
                HashSet<Integer> list = map.get(key);
                list.add(input[1]);
                return list;
            });
            map.computeIfPresent(input[1], (key, value) -> {
                HashSet<Integer> list = map.get(key);
                list.add(input[0]);
                return list;
            });
        }

        Queue<int[]> q = new LinkedList<>();
        boolean[] isVisited = new boolean[N + 1];
        q.add(new int[] { target[0], 0 });
        isVisited[target[0]] = true;
        int answer = 0;

        while (!q.isEmpty() && !isVisited[target[1]]) {
            int[] value = q.poll();
            Iterator<Integer> iter = map.get(value[0]).iterator();
            while (iter.hasNext()) {
                int num = iter.next();
                if (num == target[1]) {
                    answer = value[1] + 1;
                    isVisited[num] = true;
                    break;
                } else {
                    if (!isVisited[num]) {
                        q.add(new int[] { num, value[1] + 1 });
                        isVisited[num] = true;
                    }
                }
            }
        }

        if (isVisited[target[1]]) {
            System.out.println(answer);
        } else {
            System.out.println((-1));
        }
    }
}