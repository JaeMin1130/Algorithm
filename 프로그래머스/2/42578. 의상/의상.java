import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < clothes.length; i++){
            map.putIfAbsent(clothes[i][1], 1);
            map.computeIfPresent(clothes[i][1], (key, value) -> {
                return map.get(key) + 1;
            });
        }
        Iterator iter = map.keySet().iterator();
        while(iter.hasNext()){
            String key = String.valueOf(iter.next());
            answer *= map.get(key);
        }
        return answer-1;
    }
}