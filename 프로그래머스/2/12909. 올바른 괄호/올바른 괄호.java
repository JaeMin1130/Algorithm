class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int countBracket1 = 0;
        int countBracket2 = 0;
        char[] arr = s.toCharArray();
        for(char letter : arr){
            if(letter == '('){
                countBracket1++;
            }else{
                countBracket2++;
                if(countBracket2 > countBracket1){
                    answer = false;
                    break;
                }
            }
        }
        if(countBracket1 != countBracket2){
            answer = false;
        }
        return answer;
    }
}