import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder input = new StringBuilder(br.readLine());
        String[] letters = { "c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=" };
        
        for (String letter : letters) {
            int idx = input.indexOf(letter);
            while (idx != -1) {
                input.replace(idx, idx + letter.length(), "/");
                idx = input.indexOf(letter);
            }
        }

        System.out.println(input.length());
    }
}