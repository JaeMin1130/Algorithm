import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[][] maps) {
        
        int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        Queue<int[]> step = new LinkedList<>();
        step.add(new int[]{0, 0, 1});

        while (!step.isEmpty()) {
            
            int[] curLocation = step.poll();
            
            int curX = curLocation[0];
            int curY = curLocation[1];
            int count = curLocation[2];

            if (curX == maps.length - 1 && curY == maps[0].length - 1) {
                return count;
            }

            for (int[] dir : directions) {
                
                int nextX = curX + dir[0];
                int nextY = curY + dir[1];

                if (nextX >= 0 && nextX < maps.length && nextY >= 0 && nextY < maps[0].length) {
                    if (maps[nextX][nextY] == 1) {
                        maps[nextX][nextY] = 0;
                        step.add(new int[]{nextX, nextY, count + 1});
                    }
                }
            }
        }

        return -1;
    }
}
