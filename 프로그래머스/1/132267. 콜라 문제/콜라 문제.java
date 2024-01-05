class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        
        while(n / a >= 1){
            int value = n / a * b;
            n = n % a + value;
            answer += value;
        }
        
        return answer;
    }
}