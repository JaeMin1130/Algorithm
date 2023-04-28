import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] s = new String[5];
        char[][] arr = new char[5][15];
        for (int i = 0; i < s.length; i++) {
            s[i] = bf.readLine();
            arr[i] = s[i].toCharArray();
        }
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < arr.length; j++) {
                try {
                    System.out.print(arr[j][i]);
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.print("");
                }
            }
        }
    }
}