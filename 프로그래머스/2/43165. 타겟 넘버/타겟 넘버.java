import java.util.*;
class Solution {
    public int solution(int[] numbers, int target) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{numbers[0], 0});
        q.add(new int[]{numbers[0] * -1, 0});
        
        while(q.size() != Math.pow(2, numbers.length)){
            int[] arr = q.poll();
            int idx = arr[1] + 1;
            int num = arr[0];
            q.add(new int[]{num + numbers[idx], idx});
            q.add(new int[]{num - numbers[idx], idx});
        }
        
        int count = 0;
        while(!q.isEmpty()){
            int[] arr = q.poll();
            int idx = arr[1];
            int num = arr[0];
            if(num == target){
                count++;
            }
        }
        return count;
    }
}