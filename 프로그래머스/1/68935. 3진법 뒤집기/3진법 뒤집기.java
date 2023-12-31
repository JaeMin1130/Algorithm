class Solution {
    public int solution(int n) {
        String value = "";
        while(n != 0){
            value += String.valueOf(n % 3);
            n /= 3;
        }
        
        int answer = 0;
        int degree = 0;
        for(int i = value.length() - 1; i >= 0; i--){
            int num = value.charAt(i) - '0';
            answer += num * Math.pow(3, degree++);
        }
        
        return answer;
    }
}