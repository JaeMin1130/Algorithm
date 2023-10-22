import java.util.*;

public class Solution {
    public Object[] solution(int []arr) {
        Queue<Integer> q = new LinkedList<>(Arrays.asList(arr[0]));
        int prevNum = arr[0];
        for(int i = 1; i < arr.length; i++){
            if(arr[i] != prevNum){
                q.add(arr[i]);
            }
            prevNum = arr[i];
        }            
        return q.toArray();
    }
}