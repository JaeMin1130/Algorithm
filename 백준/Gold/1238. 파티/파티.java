import java.io.*;
import java.util.*;

class Node implements Comparable<Node> {
    int end, weight;

    public Node(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return weight - o.weight;
    }
}

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final int INF = Integer.MAX_VALUE;
    static int n, m, x;
    static List<Node>[] list;
    static int[][] dist;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        list = new ArrayList[n + 1];
        dist = new int[n + 1][n + 1];

        for (int i = 0; i < dist.length; i++) {
            Arrays.fill(dist[i], INF);
        }

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            list[start].add(new Node(end, weight));
        }

        for (int i = 1; i <= n; i++) {
            dijkstra(i);
        }

        int answer = 0;
        for (int i = 1; i < dist.length; i++) {
            answer = Math.max(answer, dist[x][i] + dist[i][x]);
        }

        bw.write(String.valueOf(answer));   
        bw.flush();
        bw.close();
        br.close();
    }

    private static void dijkstra(int start) {
        PriorityQueue<Node> q = new PriorityQueue<>();
        boolean[] isVisited = new boolean[n + 1];
        q.add(new Node(start, 0));
        dist[start][start] = 0;

        while (!q.isEmpty()) {
            Node curNode = q.poll();
            int end = curNode.end;

            if (isVisited[end] == true) continue;
            isVisited[end] = true;

            for (Node node : list[end]) {
                if (dist[start][node.end] <= dist[start][end] + node.weight) continue;

                dist[start][node.end] = dist[start][end] + node.weight;
                q.add(new Node(node.end, dist[start][node.end]));
            }
        }
    }
}