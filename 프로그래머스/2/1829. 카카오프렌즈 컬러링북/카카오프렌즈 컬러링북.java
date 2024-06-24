import java.util.*;

class Solution {
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        
        boolean[][] isVisited = new boolean[m][n];
        int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        Queue<int[]> q = new LinkedList<>();
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(picture[i][j] == 0) continue;
                if(isVisited[i][j]) continue;
                
                q.add(new int[]{i, j, picture[i][j], 1});
                isVisited[i][j] = true;
                numberOfArea++;
                
                int count = 1;
                while(!q.isEmpty()){
                    int[] info = q.poll();
                    int val = info[2];
                    
                    for(int[] dir : directions){
                        int nx = info[0] + dir[0];
                        int ny = info[1] + dir[1];
                        
                        if(nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                        if(isVisited[nx][ny]) continue;
                        if(picture[nx][ny] != val) continue;
                        
                        q.add(new int[]{nx, ny, val});
                        isVisited[nx][ny] = true;
                        count++;
                    }
                }
                maxSizeOfOneArea = Math.max(maxSizeOfOneArea, count);
            }
        }
        
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        
        return answer;
    }
}