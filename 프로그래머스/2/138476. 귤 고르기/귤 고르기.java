import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        PriorityQueue<Tangerine> q = new PriorityQueue<>((t1, t2) -> t2.amount - t1.amount);
        
        Arrays.sort(tangerine);
        int curTanger = tangerine[0];
        int count = 1;
        
        for(int i = 1; i < tangerine.length; i++){
            int tanger = tangerine[i];
            
            if(tanger != curTanger){
                q.add(new Tangerine(curTanger, count));
                curTanger = tanger;
                count = 1;
                continue;
            }
            
            count++;
        }
        
        q.add(new Tangerine(curTanger, count));
        
        if(q.isEmpty()) return 1;
        
        while(k > 0 && !q.isEmpty()){
            k -= q.poll().amount;
            answer++;
        }
        
        return answer;
    }
}

class Tangerine {
    int size;
    int amount;
    
    Tangerine(int size, int amount){
        this.size = size;
        this.amount = amount;
    }
}
