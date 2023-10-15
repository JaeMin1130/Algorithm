import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split("");
        int[] count = new int[2];
        count[Integer.parseInt(input[0])] = 1;
        String present = input[0];
        for (String string : input) {
            if (!present.equals(string)) {
                count[Integer.parseInt(string)]++;
                present = string;
            }
        }
        System.out.println(Math.min(count[0], count[1]));
    }
}