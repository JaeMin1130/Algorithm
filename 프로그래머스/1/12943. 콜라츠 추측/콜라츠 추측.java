class Solution {
    public int solution(int num) {
        if(num == 1){
            return 0;
        }
        
        long value = num;
        int answer = 0;
        
        while(value != 1){
            
            if(answer == 500){
                return -1;
            }    
            
            if(value % 2 == 0){
                value /= 2;
            }else{
                value = value * 3 + 1;
            }
            
            answer++;
        }
        
        return answer;
    }
}