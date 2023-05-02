import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class PerfectNum {
    int num;
    ArrayList<Integer> divisor = new ArrayList<Integer>();

    PerfectNum(BufferedReader bf) throws IOException {
        num = Integer.parseInt(bf.readLine());
    }

    void getDivisor(int num) {
        this.num = num;
        for (int i = 1; i < num; i++) {
            if (num % i == 0) {
                divisor.add(i);
            }
        }
    }

    void isPerfect(int num) {
        int sum = 0;
        StringBuilder list = new StringBuilder("1");
        for (int i = 0; i < divisor.size(); i++) {
            sum += divisor.get(i);
            if (i != 0) {
                list.append(String.valueOf(" + " + divisor.get(i)));
            }
        }
        if (sum == num) {
            System.out.println(num + " = " + list);
        } else {
            System.out.println(num + " is NOT perfect.");
        }
        divisor.clear();
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            PerfectNum execute = new PerfectNum(bf);
            if (execute.num != -1) {
                execute.getDivisor(execute.num);
                execute.isPerfect(execute.num);
            } else
                break;

        }
    }
}