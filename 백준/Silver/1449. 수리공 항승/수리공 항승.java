import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int len = Integer.parseInt(st.nextToken());

        int[] holes = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
        boolean[] pipe = new boolean[1001];
        for(int hole : holes){
            pipe[hole] = true;
        }

        int idx = 1;
        int count = 0;
        while(idx < pipe.length){
            if(!pipe[idx++]) continue;
            idx = idx + len - 1;
            count++;
        }

        System.out.println(count);
    }
}