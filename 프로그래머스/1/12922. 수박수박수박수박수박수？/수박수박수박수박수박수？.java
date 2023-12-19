class Solution {
    public String solution(int n) {
        
        String answer = "";
        String[] words = {"수", "박"};
        
        for(int i = 0; i < n; i++){
            answer += words[i % 2];
        }
        
        return answer;
    }
}