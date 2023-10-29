import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < priorities.length; i++){
            q.add(new int[]{i, priorities[i]});
        }
        
        PriorityQueue<Integer> priorityQue = new PriorityQueue<>((v1, v2) -> v2 - v1);
        for(int priority: priorities){
            priorityQue.add(priority);
        }
        int maxPriority = priorityQue.poll();
        
        while(!q.isEmpty()){
            int[] process = q.poll();
            if(process[1] == maxPriority){
                if(!priorityQue.isEmpty()){
                    maxPriority = priorityQue.poll();
                }
                answer++;
                if(process[0] == location){
                    break;
                }
            }else{
                q.add(process);
            }
        }
        
        return answer;
    }
}