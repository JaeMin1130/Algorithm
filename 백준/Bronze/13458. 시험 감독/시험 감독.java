import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] rooms = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int major = Integer.parseInt(st.nextToken());
        int sub = Integer.parseInt(st.nextToken());

        long count = n;
        for (int i = 0; i < rooms.length; i++) {
            int rest = rooms[i] - major;
            if(rest < 0) continue;
            
            count += rest / sub;
            count += rest % sub != 0 ? 1 : 0;
        }

        System.out.println(count);
    }
}