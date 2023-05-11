import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

class College implements Comparable<College> {
    String name;
    int drink;

    College(String name, int drink) {
        this.drink = drink;
        this.name = name;
    }
    @Override
    public int compareTo(College col) {
        int value = this.drink - col.drink;
        return value;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine());
        int num1 = 0;
        College[] list;
        for (int i = 0; i < num; i++) {
            num1 = Integer.parseInt(br.readLine());
            list = new College[num1];
            for (int j = 0; j < num1; j++) {
                String[] info = br.readLine().split(" ");
                list[j] = new College(info[0], Integer.parseInt(info[1]));
            }
            Arrays.sort(list);
            bw.write(list[num1 - 1].name + "\n");
        }
        bw.close();
    }
}