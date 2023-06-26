import java.util.Arrays;

class Solution {
     public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int idx = 0;
        for (int[] command : commands) {
            int[] slicedArr = new int[command[1] - command[0] + 1];
            for (int i = command[0] - 1, j = 0; i < command[1]; i++, j++) {
                slicedArr[j] = array[i];
            }
            Arrays.sort(slicedArr);
            answer[idx++] = (slicedArr[command[2] - 1]);
        }
        return answer;
    }
}