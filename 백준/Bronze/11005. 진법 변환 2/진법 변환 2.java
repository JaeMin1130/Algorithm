import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    private static int num;
    private static int div;

    public static void convert(int num, int div) {
        Stack<Integer> stack = new Stack<>();
        while (num / div != 0) {
            stack.push(num % div);
            num /= div;
        }
        stack.push(num);

        while (!stack.empty()) {
            if (stack.peek() >= 10) {
                System.out.print((char) ((stack.pop() + 55)));
            } else {
                System.out.print(stack.pop());
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().split(" ");
        num = Integer.parseInt(input[0]);
        div = Integer.parseInt(input[1]);
        convert(num, div);
    }
}