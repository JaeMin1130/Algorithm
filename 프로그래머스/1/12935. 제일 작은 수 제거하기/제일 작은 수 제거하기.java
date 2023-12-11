import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        int[] answer = {};
        if(arr.length - 1 == 0){
            answer = new int[]{-1};
        }else{
            answer = new int[arr.length - 1];
        }
        
        int minNum = arr[0];
        int minIdx = 0;
        for(int i = 1; i < arr.length; i++){
            if(arr[i] < minNum){
                minNum = arr[i];
                minIdx = i;
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < arr.length; i++){
            if(i != minIdx){
                list.add(arr[i]);
            }
        }
        
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}