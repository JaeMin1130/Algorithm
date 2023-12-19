class Solution {
    public int solution(int left, int right) {
        
        boolean[] check = new boolean[right + 1];
        for(int num = 1; num <= Math.sqrt(right); num++){
            check[num * num] = true;
        }
        
        int answer = 0;
        for(int num = left; num <= right; num++){
            if(check[num]){
                answer -= num;
            }else{
                answer += num;
            }
        }
        
        return answer;
    }
}