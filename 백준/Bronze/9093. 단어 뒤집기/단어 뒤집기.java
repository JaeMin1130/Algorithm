import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(bf.readLine());

        for (int i = 0; i < num; i++) {
            String[] input = bf.readLine().split(" ");
            for (int j = 0; j < input.length; j++) {
                char[] inputWord = input[j].toCharArray();
                for (int k = 0; k < inputWord.length / 2; k++) {
                    char store = inputWord[k];
                    inputWord[k] = inputWord[inputWord.length - k - 1];
                    inputWord[inputWord.length - k - 1] = store;
                }
                bw.write(inputWord);
                bw.write(" ");
                bw.flush();
            }
        }
        bw.close();
    }
}