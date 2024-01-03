import java.util.*;

class Solution {
    public int[] solution(String s) {
        
        int[] answer = new int[s.length()];
        Map<Character, Integer> map = new HashMap<>();
        
        for(int i = 0; i < s.length(); i++){
            char alphabet = s.charAt(i);
            
            if(!map.containsKey(alphabet)){
                answer[i] = -1;
            }else{
                int prevIdx = map.get(alphabet);
                answer[i] = i - prevIdx;
            }    
            
            map.put(alphabet, i);
        }
        
        return answer;
    }
}