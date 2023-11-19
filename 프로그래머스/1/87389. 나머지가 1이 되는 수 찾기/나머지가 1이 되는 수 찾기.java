class Solution {
    public int solution(int n) {
        int answer = 0;
        for(int num = 2; num < n; num++){
            if(n % num == 1){
                answer = num;
                break;
            }
        }        
        return answer;
    }
}