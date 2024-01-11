import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        Map<Character, Integer> map = new HashMap<>();
        for (String key : keymap) {
            final int[] count = { 0 };
            for (char alphabet : key.toCharArray()) {
                count[0]++;
                map.putIfAbsent(alphabet, count[0]);
                map.computeIfPresent(alphabet, (k, v) -> v > count[0] ? count[0] : v);
            }
        }

        for (int i = 0; i < targets.length; i++) {
            String target = targets[i];
            int count = 0;
            for (char alphabet : target.toCharArray()) {
                if(map.get(alphabet) == null){
                    count = -1;
                    break;
                }
                count += map.get(alphabet);
            }
            answer[i] = count;
        }

        return answer;
    }
}