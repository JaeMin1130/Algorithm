class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        
        int num = x;
        int sum = 0;
        
        while(num > 0){
            int value = num % 10;
            sum += value;
            num /= 10;
        }
        
        if(x % sum != 0){
            answer = false;
        }
        
        return answer;
    }
}