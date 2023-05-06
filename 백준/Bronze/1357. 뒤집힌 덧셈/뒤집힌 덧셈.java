import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    private String input[];
    private static StringBuilder X;
    private static StringBuilder Y;

    Main(BufferedReader br) throws IOException {
        this.input = br.readLine().split(" ");
        X = new StringBuilder(input[0]);
        Y = new StringBuilder(input[1]);
    }

    public static int rev(Object num) {
        return Integer.parseInt(new StringBuilder(num.toString()).reverse().toString());
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Main execute = new Main(br);
        bw.write(String.valueOf(rev((rev(X) + rev(Y)))));
        bw.close();
    }
}