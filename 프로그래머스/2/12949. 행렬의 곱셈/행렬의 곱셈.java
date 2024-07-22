class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        
        int[][] answer = new int[arr1.length][arr2[0].length];
        
        for(int i = 0; i < arr1.length; i++){
            
            int[] row = arr1[i];
            
            for(int j = 0; j < arr2[0].length; j++){
                int sum = 0;
                for(int k = 0; k < row.length; k++){
                    sum += row[k] * arr2[k][j];
                }
                answer[i][j] = sum; 
            }
            
        }
        
        return answer;
    }
}