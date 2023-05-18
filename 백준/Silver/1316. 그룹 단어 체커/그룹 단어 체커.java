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
        int count = 0;

        for (int i = 0; i < num; i++) {
            boolean alphabet[] = new boolean[26];
            boolean flag = true;
            char[] word = br.readLine().toCharArray();
            for (int j = 1; j < word.length; j++) {
                if (word[j - 1] != word[j]) {
                    alphabet[word[j - 1] - 97] = true;
                }
                if (alphabet[word[j] - 97]) {
                    flag = false;
                    break;
                }
            }
            if (flag)
                count++;
        }
        bw.write(String.valueOf(count));
        bw.close();
    }

}