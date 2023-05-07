import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    private static int L;
    private static int P;
    private static int V;

    public static void setNum(BufferedReader br) throws IOException {
        String[] input = br.readLine().split(" ");
        L = Integer.parseInt(input[0]);
        P = Integer.parseInt(input[1]);
        V = Integer.parseInt(input[2]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int i = 1;
        while (true) {
            Main.setNum(br);
            if (L + P + V == 0)
                break;
            if (L >= V % P) {
                bw.write("Case " + i++ + ": " + String.valueOf(L * (V / P) + V % P) + "\n");
            } else {
                bw.write("Case " + i++ + ": " + String.valueOf(L * (V / P) + L) + "\n");
            }
        }
        bw.close();
    }
}