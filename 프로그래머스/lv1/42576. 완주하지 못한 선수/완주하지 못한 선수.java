import java.util.HashMap;
import java.util.Map;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> map = new HashMap<>();
        for(String i : participant){
            map.computeIfPresent(i, (k, v) -> v + 1);
            map.putIfAbsent(i, 1);
        }
        for(String i : completion){
            map.compute(i, (k, v) -> v - 1);
        }
        for(String i : map.keySet()){
            if(map.get(i) == 1){
                answer = i;
            }
        }
        return answer;
    }
}