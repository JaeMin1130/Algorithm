import java.util.*;

class Solution {
    public List<Integer> solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < progresses.length; i++){
            int day = (100 - progresses[i]) / speeds[i];
            int rest = (100 - progresses[i]) % speeds[i];
            if(rest != 0){
                day++;
            }
            q.add(day);
        }
        int count = 1;
        int day = q.poll();
        while(!q.isEmpty()){
            int num = q.poll();
            if(day >= num){
                count++;
            }else{
                answer.add(count);
                day = num;
                count = 1;
            }
        }
        answer.add(count);
        return answer;
    }
}