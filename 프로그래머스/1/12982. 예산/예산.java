import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d);
        
        int idx = 0;
        while(budget > 0 && idx < d.length){
            budget -= d[idx++];
            answer++;
        }
        
        return budget >= 0? answer : answer - 1;
    }
}