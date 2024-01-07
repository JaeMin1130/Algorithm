class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 1;
        for(int i = 2; i <= number; i++){
            int count = 2;
            for(int j = 2; j <= Math.sqrt(i); j++){
                if(i % j == 0){
                    count += j == i / j? 1 : 2;
                }
            }
            answer += count > limit? power : count; 
        }
        return answer;
    }
}