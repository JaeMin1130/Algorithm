class Solution {
    public int[] solution(int n, int m) {
        
        int big = Math.max(n, m);
        int small = Math.min(n, m);
        int gcd = uclid(big, small);
        int lcm = (big / gcd) * (small / gcd) * gcd;
        
        return new int[]{gcd, lcm};
    }
    
    private int uclid(int big, int small){
        if(small == 0){
            return big;
        }else{
            return uclid(small, big % small);
        }
    }
}