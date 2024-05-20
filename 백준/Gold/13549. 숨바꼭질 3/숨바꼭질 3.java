import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static boolean[] isVisited = new boolean[200001];
    static int[] directions = {1, -1};
    static int subin;
    static int brother;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        StringTokenizer input = new StringTokenizer(br.readLine());
        subin = Integer.parseInt(input.nextToken());
        brother = Integer.parseInt(input.nextToken());

        if(subin == brother){
            System.out.println(0);
            return;
        }
        
        Queue<int[]> q = new LinkedList<>();

        q.add(subin == 0? new int[]{++subin, 1} : new int[]{subin, 0});
        isVisited[subin] = true;

        seek(q);

        System.out.println(answer);
    }

    static void seek(Queue<int[]> q) {
        
        while (!q.isEmpty()) {
            int[] curStat = q.poll();
            int curLoc = curStat[0];
            int time = curStat[1];
            int nextLoc = curLoc;

            while(nextLoc < brother){
                nextLoc *= 2;
                if(isVisited[nextLoc]) continue;

                q.add(new int[]{nextLoc, time});
                isVisited[nextLoc] = true;
            }

            if (curLoc >= brother) {
                time += (curLoc - brother);
                answer = Math.min(answer, time);
                continue;
            }

            for(int dir : directions){
                nextLoc = curLoc + dir;
                if(nextLoc <= 0 || nextLoc > 200000) continue;
                if(isVisited[nextLoc]) continue;

                if(nextLoc == brother){
                    answer = Math.min(answer, time + 1);
                    continue;
                }

                q.add(new int[]{nextLoc, time+1});
                isVisited[nextLoc] = true;
            }
        }
    }
}