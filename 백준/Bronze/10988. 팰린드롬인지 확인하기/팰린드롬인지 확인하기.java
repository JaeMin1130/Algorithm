 import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.next();
        String[] arr = word.split("");
        boolean flag = true;

        for (int i = 0; i <= arr.length / 2; i++) {
            if (!arr[i].equals(arr[arr.length - i - 1])) {
                flag = false;
            }
        }
        if (flag) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
        scanner.close();
    }
}