import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    static int[] location;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(input.nextToken());
        int row = Integer.parseInt(input.nextToken());
        int col = Integer.parseInt(input.nextToken());
        location = new int[16];
        int temp = N;
        while (location[1] == 0) {
            int st = ((int) Math.pow(2, temp) - 1) / 2;
            if (row > st && col > st) {
                location[temp] = 4;
                row = row - (st + 1);
                col = col - (st + 1);
            } else if (row > st && col <= st) {
                location[temp] = 3;
                row = row - (st + 1);
            } else if (row <= st && col <= st) {
                location[temp] = 1;
            } else {
                location[temp] = 2;
                col = col - (st + 1);
            }
            temp -= 1;
        }
        int val = 0;
        for (int i = N; i >= 1; i--) {
            val += (location[i] - 1) * (int) Math.pow(2, 2 * i - 2);
        }
        System.out.println(val);
    }
}