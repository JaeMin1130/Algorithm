import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static int m;
    static int[] arr;
    static List<int[]> list = new ArrayList<>();

    public static void main(String[] args) throws NumberFormatException, IOException {
        StringTokenizer input = new StringTokenizer(br.readLine());

        n = Integer.parseInt(input.nextToken());
        m = Integer.parseInt(input.nextToken());

        arr = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();

        combination(0, new int[m], new boolean[n]);

        for(int[] element : list){
            for (int num : element) {
                bw.write(num + " ");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }

    static void combination(int idx, int[] result, boolean[] isUsed) throws IOException {
        if (idx == result.length) {
            if(isDuplicate(result)) return;

            list.add(result);
            
            return;
        }

        for (int i = 0; i < n; i++) {
            if (isUsed[i]) continue;

            result[idx] = arr[i];
            isUsed[i] = true;

            combination(idx + 1, result.clone(), isUsed.clone());
            isUsed[i] = false;
        }
    }

    static boolean isDuplicate(int[] result){
        for(int[] element : list){
            if(Arrays.equals(element, result)) return true;
        }
        return false;
    }
}