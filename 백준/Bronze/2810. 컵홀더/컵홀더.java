import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine());
        char[] arr = br.readLine().toCharArray();
        int countL = 0;
        for (int i = 0; i < arr.length;) {
            if (arr[i] == 'L') {
                i += 2;
                countL++;
            } else
                i++;
        }
        int countCupHolder = (num + 1) - countL;
        if (countCupHolder >= num) {
            bw.write(String.valueOf(num));
        } else {
            bw.write(String.valueOf(countCupHolder));
        }
        bw.close();
    }
}