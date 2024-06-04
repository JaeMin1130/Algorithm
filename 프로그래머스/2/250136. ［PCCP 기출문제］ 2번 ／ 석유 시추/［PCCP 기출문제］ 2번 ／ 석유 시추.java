import java.util.*;

class Solution {
    public int solution(int[][] land) {
        int row = land.length;
        int col = land[0].length;
        
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        int mark = 2;
        int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        Queue<int[]> q = new LinkedList<>();
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                
                if (land[i][j] != 1) continue;
                
                q.add(new int[]{i, j});
                land[i][j] = mark;
                int sum = 1;
                                
                while (!q.isEmpty()) {
                    int[] curInfo = q.poll();
                    for (int[] dir : directions) {
                        int nx = curInfo[0] + dir[0];
                        int ny = curInfo[1] + dir[1];
                        
                        if (nx < 0 || nx >= row || ny < 0 || ny >= col) continue;
                        if (land[nx][ny] != 1) continue;
                        
                        q.add(new int[]{nx, ny});
                        land[nx][ny] = mark;
                        sum++;
                    }
                }
                map.put(mark, sum);
                mark++;
            }
        }
        
        int answer = 0;
        for (int i = 0; i < col; i++) {
            int prevNum = 0;
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < row; j++) {
                set.add(land[j][i]);
            }
            int sum = 0;
            for(int num : set){
                sum += map.get(num);
            }
            answer = Math.max(answer, sum);
        }
        return answer;
    }
}
