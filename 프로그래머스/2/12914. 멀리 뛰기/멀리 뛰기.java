class Solution {
    static long[] memo;
    
    public long solution(int n) {
        if(n == 1) return 1;
        
        memo = new long[n + 1];
        memo[1] = 1;
        memo[2] = 2;
        
        return recur(n);
    }
    
    private long recur(int n){
        
        if(memo[n] == 0){
            memo[n] = (recur(n - 1) + recur(n - 2)) % 1234567;
        }
        
        return memo[n];
    }
}