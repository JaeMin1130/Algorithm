class Solution {
    public int[] solution(int n, int m) {
        
        int gcd = uclid(n, m);
        int lcm = n * m / gcd;
        
        return new int[]{gcd, lcm};
    }
    
    private int uclid(int n, int m){
        if(m == 0){
            return n;
        }else{
            return uclid(m, n % m);
        }
    }
}