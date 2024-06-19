class Solution {
    public int solution(int n) {
        int answer = 1;
        
        for(int start = 1; start <= n / 2; start++){
            int sum = 0;
            int num = start;
            while(sum < n){
                sum += num++;
            }
            if(sum > n) continue;
            answer++;
        }        
        
        return answer;
    }
}