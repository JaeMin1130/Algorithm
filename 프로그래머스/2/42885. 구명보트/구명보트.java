import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        Arrays.sort(people);
        
        int startIdx = 0;
        int endIdx = people.length - 1;
        while(startIdx <= endIdx){
            answer++;
            
            if(people[startIdx] + people[endIdx--] > limit) continue;
            
            startIdx++;
        }
        
        return answer;
    }
}