import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        
        int[] answer = new int[photo.length];
        
        Map<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i < name.length; i++){
            map.put(name[i], yearning[i]);
        }
        
        for(int i = 0; i < photo.length; i++){
            int sum = 0;
            String[] singlePhoto = photo[i];
            
            for(String person : singlePhoto){
                map.putIfAbsent(person, 0);
                sum += map.get(person);
            }
            
            answer[i] = sum;
        }
        
        return answer;
    }
}