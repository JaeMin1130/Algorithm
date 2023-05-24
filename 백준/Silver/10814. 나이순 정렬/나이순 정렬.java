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
        StringBuilder[] arr = new StringBuilder[201];

        for (int i = 0; i < num; i++) {
            String person = br.readLine();
            int age = Integer.parseInt(person.split(" ")[0]);
            if (arr[age] == null) {
                arr[age] = new StringBuilder(person);
            } else {
                StringBuilder str = new StringBuilder("\n" + person);
                arr[age].append(str);
            }
        }
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null) {
                bw.write(arr[i].toString() + "\n");
            }
        }
        bw.close();
    }
}