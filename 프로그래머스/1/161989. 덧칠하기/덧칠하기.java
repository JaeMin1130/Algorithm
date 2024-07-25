class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        
        int sum = 0;
        for(int sec : section){
            if(sum > sec) continue;
            
            sum = sec;
            sum += m;
            answer++;
        }
            
        return answer;
    }
}