import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine().trim();

        Stack<Integer> stack = new Stack<>();
        int answer = 0;

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);

            if (currentChar == '(') {
                stack.push(i);
            } else {
                if (stack.peek() + 1 == i) { // 레이저면
                    stack.pop();
                    answer += stack.size(); // 현재 레이저로 잘리는 부분 갯수
                } else {    // 막대 끝이면
                    stack.pop();
                    answer++; // 안 잘리고 남은 부분 count
                }
            }
        }

        System.out.println(answer);
    }
}