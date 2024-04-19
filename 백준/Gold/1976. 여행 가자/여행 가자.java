import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[][] routes = new int[n + 1][n + 1];
        for (int i = 1; i < routes.length; i++) {
            int[] input = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 1; j < routes.length; j++) {
                routes[i][j] = input[j - 1];
            }
        }

        int[] plan = new int[m];
        plan = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        if(n == 1) {
            System.out.println("YES");
            return;
        }

        int departure = plan[0];
        int arrival = plan[1];
        boolean isTravelable = isReachable(departure, arrival, routes, new boolean[n + 1])? true : false;
        for (int i = 2; i < plan.length; i++) {
            if (!isReachable(departure, arrival, routes, new boolean[n + 1])) {
                isTravelable = false;
                break;
            }
            departure = plan[i - 1];
            arrival = plan[i];
        }

        System.out.println(isTravelable ? "YES" : "NO");
    }

    static boolean isReachable(int departure, int arrival, int[][] routes, boolean[] isVisited) {
        
        if(routes[departure][arrival] == 1 || departure == arrival) return true;

        for (int i = 0; i < routes.length; i++) {
            if(i == departure || i == arrival || isVisited[i]) continue;
            if(routes[departure][i] == 0) continue;

            isVisited[departure] = true;
            if(isReachable(i, arrival, routes, isVisited)) return true;
        }

        return false;
    }
}