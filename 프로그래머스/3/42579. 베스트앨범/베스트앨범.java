import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Stream;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        
        Map<String, ArrayList<Integer>> map = new HashMap<>();       
        for(int i = 0; i < genres.length; i++){
            map.putIfAbsent(genres[i], new ArrayList<Integer>());
            ArrayList<Integer> list = map.get(genres[i]);
            list.add(i);
        }
        
        Map<Integer, String> sumMap = new HashMap<>();
        PriorityQueue<Integer> q = new PriorityQueue<>((v1, v2) -> v2 - v1);
        for(String key : map.keySet()){
            int sum = 0;
            for(int idx : map.get(key)){
                sum += plays[idx];
            }
            sumMap.put(sum, key);
            q.add(sum);
        }
        
        ArrayList<Integer> answer = new ArrayList<>();
        while(!q.isEmpty()){
            int sum = q.poll();
            String key = sumMap.get(sum);
            ArrayList<Integer> list = map.get(key);
            list.sort((v1, v2) -> plays[v2] - plays[v1]);
            if(list.size() == 1){
                answer.add(list.get(0));
            }else{
                answer.add(list.get(0));
                answer.add(list.get(1));
            }
        }
        
        return answer.parallelStream().mapToInt(Integer::valueOf).toArray();
    }
}