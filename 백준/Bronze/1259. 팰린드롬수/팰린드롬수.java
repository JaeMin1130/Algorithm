import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static void palin() {
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> result = new ArrayList<String>();

        while (true) {
            int input = scanner.nextInt();
            if (input == 0)
                break;

            String inputStr = Integer.toString(input);
            char[] arr = (inputStr).toCharArray();
            int count = 0;

            for (int i = 0; i < arr.length / 2; i++) {
                if (arr[i] == arr[arr.length - i - 1]) {
                    count++;
                }
            }

            if (count == arr.length / 2) {
                result.add("yes");
            } else {
                result.add("no");
            }
        }
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }

    public static void main(String[] args) {
        palin();
    }
}