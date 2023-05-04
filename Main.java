import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class Convert {
    private static int decimal;

    static void toDecimal() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder biNum = new StringBuilder(br.readLine());
        char[] revArr = biNum.reverse().toString().toCharArray();

        for (int i = 0; i < revArr.length; i++) {
            if (revArr[i] == '1') {
                decimal += (int) (Math.pow(2, i));
            }
        }
    }

    static void toOctal() throws IOException {
        Stack<Integer> stack = new Stack<>();
        while (decimal / 8 != 0) {
            stack.push(decimal % 8);
            decimal /= 8;
        }
        stack.push(decimal);
        while (!stack.empty()) {
            System.out.print(stack.pop());
        }
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        Convert.toDecimal();
        Convert.toOctal();
    }
}