class Solution {
    public int solution(int[] numbers) {
        
        int answer = 0;
        boolean[] isPresent = new boolean[10];
        
        for(int num : numbers){
            isPresent[num] = true;
        }
        
        for(int i = 0; i < 10; i++){
            if(!isPresent[i]){
                answer += i;
            }
        }
        
        return answer;
    }
}