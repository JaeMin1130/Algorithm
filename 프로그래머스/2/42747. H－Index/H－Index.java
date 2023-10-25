import java.util.*;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int answer = citations.length;
        boolean flag = false;
        for(int i = 0; i < citations.length; i++){
            if(citations[i] >= answer - i){
                answer -= i;
                flag = true;
                break;
            }
        } 
        if(!flag){
            answer = 0;
        }
        return answer;
    }
}