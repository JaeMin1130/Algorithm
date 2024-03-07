import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] parentInfo = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int rm = Integer.parseInt(br.readLine());

        // 부모-자식 관계 매핑
        int[] tree = new int[n];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int node = 0; node < parentInfo.length; node++) {
            int info = parentInfo[node];
            if (info == -1) {
                tree[0] = node;
                continue;
            }
            List<Integer> list;
            list = map.containsKey(info)? map.get(info) : new ArrayList<>();
            list.add(node);
            map.computeIfPresent(info, (k, v) -> list);
            map.putIfAbsent(info, list);
        }

        // 트리 생성
        Queue<List<Integer>> q = new LinkedList<>();
        if(map.containsKey(tree[0])){
            q.add(map.get(tree[0]));
        }
        int idx = 1;
        while (!q.isEmpty()) {
            for (int num : q.poll()) {
                if (num == 999) continue;
                if (map.containsKey(num)) {
                    q.add(map.get(num));
                }
                tree[idx++] = num;
            }
        }

        // 삭제된 노드 메모
        boolean[] isRemoved = new boolean[n];
        for (int node : tree) {
            if (node != rm) continue;
            if (map.containsKey(node)) {
                q.add(map.get(node));
            }
            isRemoved[node] = true;
            while (!q.isEmpty()) {
                for (int num : q.poll()) {
                    if (num == 999) continue;
                    isRemoved[num] = true;
                    if (map.containsKey(num)) {
                        q.add(map.get(num));
                    }
                }
            }
        }

        // 리프 노드 count
        int count = 0;
        for (int node : tree) {
            if (isRemoved[node]) continue;
            if (!map.containsKey(node)) count++;
            if(map.containsKey(node) && map.get(node).size() == 1 && isRemoved[map.get(node).get(0)]) count++;  // 루트 노드가 리프 노드일 경우
        }

        System.out.println(count);
    }
}