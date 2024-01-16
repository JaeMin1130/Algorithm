import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int L = Integer.parseInt(br.readLine());
        String S = br.readLine();
        int n = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();
        for (String s : S.split(" ")) {
            int num = Integer.parseInt(s);
            if (num == n) {
                System.out.println(0);
                return;
            }
            list.add(num);
        }
        list.add(n);
        list.sort((v1, v2) -> v1 - v2);
        int idx = list.indexOf(n);
        int answer = 0;
        int min = 0;
        int max = 0;
        if (idx == 0) {
            min = 1;
            max = list.get(idx + 1) - 1;
            answer -= 1;
        } else if (idx == list.size() - 1) {
            min = list.get(idx - 1) + 1;
            max = n;
        } else {
            min = list.get(idx - 1) + 1;
            max = list.get(idx + 1) - 1;
            answer -= 1;
        }
        for (int i = min; i <= n; i++) {
            for (int j = n; j <= max; j++) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}