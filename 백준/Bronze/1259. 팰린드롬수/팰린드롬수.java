import java.util.Scanner;

public class Main {
    static void palin() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String input = scanner.next();
            if (input.equals("0"))
                break;

            char[] arr = (input).toCharArray();
            int count = 0;

            for (int i = 0; i < arr.length / 2; i++) {
                if (arr[i] == arr[arr.length - i - 1]) {
                    count++;
                }
            }

            if (count == arr.length / 2) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }

    }

    public static void main(String[] args) {
        palin();
    }
}