import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String[] arr = br.readLine().split("");
            int[] count = new int[2];
            for (String str : arr) {
                if (str.equals("(")) {
                    count[0]++;
                } else {
                    count[1]++;
                }
                if (count[0] < count[1]) {
                    System.out.println("NO");
                    break;
                }
            }
            if (count[0] == count[1]) {
                System.out.println("YES");
            } else if (count[0] > count[1]) {
                System.out.println("NO");
            }
        }
    }
}
