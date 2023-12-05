import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    static int result = 0;
    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        recur(0, new int[N], new boolean[N]);

        System.out.println(result);
    }

    static void recur(int idx, int[] sequence, boolean[] isContained) {
        if (idx == N) {

            int sum = calFormula(sequence);

            if (result < sum) {
                result = sum;
            }
            
            return;

        } else {
            for (int i = 0; i < arr.length; i++) {
                
                if (!isContained[i]) {
                    sequence[idx] = arr[i];
                    isContained[i] = true;
                    recur(idx + 1, sequence, isContained);
                    isContained[i] = false;
                } 
            }
        }
    }

    static int calFormula(int[] sequence) {

        int sum = 0;
        
        for (int i = 0; i < sequence.length - 1; i++) {
            int value = Math.abs(sequence[i] - sequence[i + 1]);
            sum += value;
        }

        return sum;
    }
}