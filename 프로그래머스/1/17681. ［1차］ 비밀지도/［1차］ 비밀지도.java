import java.util.*;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        int[][] map1 = convertIntoBinary(n, arr1);
        int[][] map2 = convertIntoBinary(n, arr2);
        
        for(int i = 0; i < n; i++){
            String line = "";
            for(int j = n - 1; j >= 0; j--){
                int value = map1[i][j] + map2[i][j];
                line += value >= 1? "#" : " ";
            }
            answer[i] = line;
        }
        
        return answer;
    }
    
    private int[][] convertIntoBinary(int n, int[] arr){
        int[][] map = new int[n][n];
        int idx = 0;
        
        for(int num : arr){
            int[] binaryArr = new int[n];
            for(int i = 0; i < n; i++){
                binaryArr[i] = num % 2;
                num /= 2;
            }
            map[idx++] = binaryArr;
        }
        
        return map;
    }
}