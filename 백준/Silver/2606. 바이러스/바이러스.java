import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int com = Integer.parseInt(br.readLine());
        int link = Integer.parseInt(br.readLine());
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < link; i++) {
            String[] input = br.readLine().split(" ");
            map.computeIfPresent(input[0], (k, v) -> map.get(k).concat(" " + input[1]));
            map.computeIfPresent(input[1], (k, v) -> map.get(k).concat(" " + input[0]));
            map.putIfAbsent(input[0], new String(input[1]));
            map.putIfAbsent(input[1], new String(input[0]));
        }
        List<String> list = new ArrayList<>();
        list.add("1");
        int idx = 0;
        try {
            do {
                String key = list.get(idx);
                String[] val = map.get(key).split(" ");
                for (String s : val) {
                    if (!list.contains(s)) {
                        list.add(s);
                    }
                }
                idx++;
            } while (idx < com);
        } catch (Exception e) {
        } finally {
            System.out.println(list.size() - 1);
        }
    }
}