import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

class Convert {

    static void toOctal() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<String> stack = new Stack<>();
        String input = br.readLine();

        for (int i = 0; i < input.length(); i++) {
            stack.push(String.valueOf(input.charAt(i)));
        }

        int sum = 0;
        int i = 0;
        int[] arr = { 1, 2, 4 };
        StringBuilder octal = new StringBuilder();

        while (!stack.empty()) {
            while (i < arr.length) {
                if (stack.pop().equals("1")) {
                    sum += arr[i++];
                } else
                    i++;
                if (stack.empty())
                    break;

            }
            octal.append(String.valueOf(sum));
            sum = 0;
            i = 0;
        }
        bw.write(octal.reverse().toString());
        bw.close();
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        Convert.toOctal();
    }
}
