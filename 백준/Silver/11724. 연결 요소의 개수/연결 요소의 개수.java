import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nums = br.readLine().split(" ");
        int N = Integer.parseInt(nums[0]);
        int M = Integer.parseInt(nums[1]);

        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < M; i++) {
            String[] input = br.readLine().split(" ");
            map.computeIfPresent(input[0], (k, v) -> map.get(k).concat(" " + input[1]));
            map.computeIfPresent(input[1], (k, v) -> map.get(k).concat(" " + input[0]));
            map.putIfAbsent(input[0], new String(input[1]));
            map.putIfAbsent(input[1], new String(input[0]));
        }

        List<List<String>> result = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        List<String> nodeList = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            nodeList.add(String.valueOf(i));
        }
        int idx = 0;
        temp.add("1");
        while (!nodeList.isEmpty()) {
            int len = temp.size();
            if (map.keySet().contains(temp.get(idx))) {
                String[] val = map.get(temp.get(idx)).split(" ");
                nodeList.remove(temp.get(idx++));
                for (String i : val) {
                    if (!temp.contains(i)) {
                        temp.add(i);
                    }
                }
                if (temp.size() == len && !temp.isEmpty() && idx >= temp.size()) {
                    result.add(temp);
                    temp = new ArrayList<>();
                    if (nodeList.iterator().hasNext()) {
                        temp.add(String.valueOf(nodeList.iterator().next()));
                        idx = 0;
                    }
                }
            } else {
                result.add(temp);
                nodeList.remove(temp.get(idx));
                temp = new ArrayList<>();
                if (nodeList.iterator().hasNext()) {
                    temp.add(String.valueOf(nodeList.iterator().next()));
                    idx = 0;
                }
            }
        }
        if (M == 0) {
            System.out.println(N);
        } else {
            System.out.println(result.size());
        }
    }
}