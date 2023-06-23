import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.computeIfPresent(i, (k, v) -> v + 1);
            map.putIfAbsent(i, 1);
        }
        int answer = 0;
        answer = map.keySet().size() >= nums.length / 2? nums.length / 2 : map.keySet().size();
        return answer;
    }
}