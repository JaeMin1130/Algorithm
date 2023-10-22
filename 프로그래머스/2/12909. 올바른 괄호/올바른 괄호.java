class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int count = 0;
        char[] arr = s.toCharArray();
        for(char letter : arr){
            if(letter == '('){
                count++;
            }else{
                count--;
                if(count < 0) {
                    answer = false;
                    break;
                }
            }
        }
        if(count != 0){
            answer = false;
        }
        return answer;
    }
}