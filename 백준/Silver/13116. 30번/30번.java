import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] tree = new int[1023];
        for (int i = 0; i < tree.length; i++) {
            tree[i] = i + 1;
        }
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer input = new StringTokenizer(br.readLine());
            PriorityQueue<Integer> q = new PriorityQueue<>((v1, v2) -> v2 - v1);
            int arrival1 = Integer.parseInt(input.nextToken());
            int arrival2 = Integer.parseInt(input.nextToken());
            downTree(q, Math.max(arrival1, arrival2));
            downTree(q, Math.min(arrival1, arrival2));
            int result = q.poll();
            while(!q.isEmpty()){
                if(result == q.peek()){
                    System.out.println(result * 10);
                    break;
                }else{
                    result = q.poll();
                }
            }
        }
    }
    
    private static void downTree(PriorityQueue<Integer> q, int node){
        q.add(node);
        if(node <= 1){
            return;
        }else{
            downTree(q, node/2);
        }
    }
}