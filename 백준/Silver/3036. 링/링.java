import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer input = new StringTokenizer(br.readLine());
        int deno = Integer.parseInt(input.nextToken());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < N - 1; i++) {
            int nume = Integer.parseInt(input.nextToken());
            int gcd = getGcd(nume, deno);
            bw.write(String.valueOf(deno / gcd) + "/" + String.valueOf(nume / gcd) + "\n");
        }
        bw.flush();
        bw.close();
    }

    static int getGcd(int nume, int deno) {
        if (deno == 0)
            return nume;
        else
            return getGcd(deno, nume % deno);
    }
}