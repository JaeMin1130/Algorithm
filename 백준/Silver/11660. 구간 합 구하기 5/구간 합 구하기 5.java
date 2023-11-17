import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.stream.Stream;
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer NM = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(NM.nextToken());
        int M = Integer.parseInt(NM.nextToken());

        int[][] singleLineCumSum = new int[N][N];
        for (int i = 0; i < N; i++) {

            int[] line = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int sum = 0;

            for (int j = 0; j < N; j++) {
                sum += line[j];
                singleLineCumSum[i][j] = sum;
            }

        }
        
        for (int i = 0; i < M; i++) {
           
            int[] target = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int startRow = target[0] - 1;
            int endRow = target[2] - 1;
            int startCol = target[1] - 1;
            int endCol = target[3] - 1;

            int intervalSum = 0;
            for(int row = startRow; row <= endRow; row++){
                intervalSum += startCol == 0? singleLineCumSum[row][endCol] : singleLineCumSum[row][endCol] - singleLineCumSum[row][startCol - 1];
            }
            bw.write(String.valueOf(intervalSum) + "\n");

        }

        bw.flush();
        bw.close();
        
    }
}