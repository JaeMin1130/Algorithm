import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split("-");
        int[] result = new int[input.length];

        for (int i = 0; i < input.length; i++) {
            if (input[i].indexOf("+") == -1) {
                result[i] = Integer.parseInt(input[i]);
            } else {
                String[] temp = input[i].split("\\+");
                for (String str : temp) {
                    result[i] += Integer.parseInt(str);
                }
            }
        }

        int sum = result[0];
        for (int i = 1; i < result.length; i++) {
            sum -= result[i];
        }

        System.out.println(sum);
    }
}