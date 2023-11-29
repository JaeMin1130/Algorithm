class Solution {
    public long solution(int a, int b) {
        long answer = 0;
        
        int small = Math.min(a, b);
        int big = Math.max(a, b);
        
        for(int num = small; num <= big; num++){
            answer += num;
        }
        
        return answer;
    }
}