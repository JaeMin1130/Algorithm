import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0, 0};
        
        Set<String> set = new HashSet<>();
        String prevWord = words[0];
        set.add(prevWord);
        
        for(int i = 1; i < words.length; i++){
            String curWord = words[i];
            
            if(set.contains(curWord) || prevWord.charAt(prevWord.length() - 1) != curWord.charAt(0)){
                answer[0] = i % n + 1;
                answer[1] = i / n + 1;
                return answer;
            }
            
            prevWord = curWord;
            set.add(curWord);
        }
        
        return answer;
    }
}