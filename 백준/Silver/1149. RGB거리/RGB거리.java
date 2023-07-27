import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

class Main {
    static int[][] rgb;
    static int[][] memo;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        memo = new int[N][3];
        rgb = new int[N][3];
        for (int i = 0; i < N; i++) {
            rgb[i] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        System.out.println(Math.min(Math.min(cal(0, 0), cal(0, 1)), cal(0, 2)));
    }

    static int cal(int h, int c) {
        if (memo[h][c] != 0) {
            return memo[h][c];
        } else {
            if (h == N - 1) {
                return rgb[h][c];
            } else {
                switch (c) {
                    case 0:
                        memo[h][c] = rgb[h][c] + Math.min(cal(h + 1, 1), cal(h + 1, 2));
                        break;
                    case 1:
                        memo[h][c] = rgb[h][c] + Math.min(cal(h + 1, 0), cal(h + 1, 2));
                        break;
                    case 2:
                        memo[h][c] = rgb[h][c] + Math.min(cal(h + 1, 0), cal(h + 1, 1));
                        break;
                }
            }
            return memo[h][c];
        }
    }
}