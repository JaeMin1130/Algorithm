import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
    private static int num;
    private static int div;

    public static void convert(int num, int div) throws IOException {
        Stack<Integer> stack = new Stack<>();
        while (num / div != 0) {
            stack.push(num % div);
            num /= div;
        }
        stack.push(num);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (!stack.empty()) {
            if (stack.peek() >= 10) {
                bw.write((char) ((stack.pop() + 55)));
            } else {
                bw.write(String.valueOf(stack.pop()));
            }
        }
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().split(" ");
        num = Integer.parseInt(input[0]);
        div = Integer.parseInt(input[1]);
        convert(num, div);
    }
}