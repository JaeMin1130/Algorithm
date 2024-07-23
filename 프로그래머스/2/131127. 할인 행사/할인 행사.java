import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        for(int i = 0; i <= discount.length - 10; i++){
            Map<String, Integer> map = new HashMap<>();
            for(int k = 0; k < want.length; k++){
                map.put(want[k], number[k]);
            }
            int count = 10;
            for(int j = i; j < i + 10; j++){
                String curStuff = discount[j];
                if(!map.keySet().contains(curStuff)) continue;
                if(map.keySet().contains(curStuff) && map.get(curStuff) == 0) continue;
                
                count--;
                map.computeIfPresent(curStuff, (k, v) -> v - 1);
            }
            
            if(count == 0) answer++;
        }
        
        return answer;
    }
}