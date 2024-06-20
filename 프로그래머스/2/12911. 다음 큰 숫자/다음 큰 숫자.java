class Solution {
    public int solution(int n) {
        int answer = 0;
        int idx = 1;
        while(answer == 0){
            int nextNum = n + idx++;
            if(countOne(n) != countOne(nextNum)) continue;
            answer = nextNum;
        }
        return answer;
    }
    
    private int countOne(int n){
        int result = 0;
        
        while(n > 0){
            if(n % 2 == 1) result++;
            n /= 2;
        }
        
        return result;
    }
}