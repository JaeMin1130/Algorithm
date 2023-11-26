class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int pNum = 0;
        int yNum = 0;
        
        char[] arr = s.toCharArray();
        
        for(char alphabet : arr){
            if(alphabet == 'p' || alphabet == 'P'){
                pNum++;
            }else if(alphabet == 'y' || alphabet == 'Y'){
                yNum++;
            }
        }

        if(pNum != yNum){
            answer = false;
        }
            
        return answer;
    }
}