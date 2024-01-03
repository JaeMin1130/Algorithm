import java.util.*;

class Solution {
    static int answer = 0;
    
    public int solution(int[] number) {
        
        permutation(0, 0, new int[3], number);
        
        return answer;
    }
    
    private void permutation(int idx, int numIdx, int[] arr, int[] number) {
        if (idx == 3) {
            int sum = 0;
            
            for(int num : arr){
                sum += num;
            }
            
            if(sum == 0){
                answer++;
            }
            
        } else {
            for (int i = numIdx; i < number.length; i++) {
                arr[idx] = number[i];
                permutation(idx + 1, i + 1, arr, number);
            }
        }
    }
}
