class Solution {
    static int[] memo = new int[100001];
    
    public int solution(int n) {
        memo[1] = 1;
        memo[2] = 1;
        int answer = fibo(n);
        return answer;
    }
    
    private int fibo(int n){
        if(memo[n] == 0){
            if(!(n == 2 || n == 1)){
                memo[n] = (fibo(n - 1) + fibo(n - 2)) % 1234567;
            }
        }
        return memo[n];
    }
    
}