import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num1 = Integer.parseInt(br.readLine());
        String[] input1 = br.readLine().split(" ");
        int[] ownCard = new int[num1];
        for (int i = 0; i < input1.length; i++) {
            ownCard[i] = Integer.parseInt(input1[i]);
        }

        int num2 = Integer.parseInt(br.readLine());
        String[] check = br.readLine().split(" ");

        Arrays.sort(ownCard);

        for (int i = 0; i < check.length; i++) {
            if (Arrays.binarySearch(ownCard, Integer.parseInt(check[i])) >= 0) {
                bw.write(1 + " ");
            } else {
                bw.write(0 + " ");
            }
        }
        bw.close();
    }
}