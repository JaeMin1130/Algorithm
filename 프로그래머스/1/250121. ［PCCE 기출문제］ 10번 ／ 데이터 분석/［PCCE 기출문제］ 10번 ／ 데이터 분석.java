import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        
        Map<String, Integer> map = new HashMap<>();
        map.put("code", 0);
        map.put("date", 1);
        map.put("maximum", 2);
        map.put("remain", 3);
        
        int sortIdx = map.get(sort_by);
        PriorityQueue<int[]> dataList = new PriorityQueue<>((arr1, arr2) -> arr1[sortIdx] - arr2[sortIdx]);
        
        int filterIdx = map.get(ext);
        for(int[] arr : data){
            if(arr[filterIdx] < val_ext){
                dataList.add(arr);
            }
        }
        
        int[][] answer = new int[dataList.size()][4];
        for(int i = 0; i < answer.length; i++){
            answer[i] = dataList.poll();
        }
        
        return answer;
    }
    
}
