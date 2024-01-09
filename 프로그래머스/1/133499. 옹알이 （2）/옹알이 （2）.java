import java.util.*;

class Solution {
    static String[] arr = {"aya", "ye", "woo", "ma"};
    
    public int solution(String[] babbling) {
        int answer = 0;
        
        for(String word : babbling){
            int idx = 0;
            boolean[] isUsed = new boolean[4];
            while(idx < 4){
                if(!isUsed[idx] && word.startsWith(arr[idx])){
                    word = word.replaceFirst(arr[idx], "");
                    Arrays.fill(isUsed, false);
                    isUsed[idx] = true;
                    idx = 0;
                    continue;    
                }
                idx++;
            }
            if(word.equals("")){
                answer++;
            }
        }
        return answer;
    }

}