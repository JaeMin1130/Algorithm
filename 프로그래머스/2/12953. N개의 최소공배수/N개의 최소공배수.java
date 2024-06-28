class Solution {
    public int solution(int[] arr) {
        int answer = lcm(arr[0], arr[1]);
        
        for(int i = 2; i < arr.length; i++){
            answer = lcm(answer, arr[i]);
        }
        
        return answer;
        
    }
    
    private int lcm(int n1, int n2){
        return n1 * n2 / gcd(n1, n2);
    }
    
    private int gcd(int n1, int n2){
        if(n2 == 0) return n1;
        return gcd(n2, n1 % n2);
    }
}
