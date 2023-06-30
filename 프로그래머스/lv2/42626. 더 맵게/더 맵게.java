import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {
    public static int solution(int[] scoville, int K) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int i : scoville) {
            q.add(i);
        }
        
        int count = 0;
        while (q.size() >= 2 && q.peek() < K) {
            int first = q.poll();
            int second = q.poll();

            int sum = first + 2 * second;
            q.add(sum);
            count++;
        }

        return q.peek() >= K ? count : -1;
    }
}