import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class Main {

    static int S;
    static int[] sequence;
    static int answer;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer input = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(input.nextToken());
        S = Integer.parseInt(input.nextToken());

        sequence = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i = 1; i <= N; i++) {
            int[] arr = new int[i];
            recur(0, 0, arr);
        }

        System.out.println(answer);
    }

    private static void recur(int idx, int val, int[] arr){
        if(idx == arr.length){
            int sum = 0;
            for (int num : arr) {
                sum += num;
            }
            
            if(sum == S){
                answer++;
            }

        }else{
            for (int i = val; i < sequence.length; i++) {
                arr[idx] = sequence[i];
                recur(idx + 1, i + 1, arr);
            }
        }
    }
    
}
