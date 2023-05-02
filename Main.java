import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        long num = scanner.nextLong();
        scanner.close();

        long cat = 1;
        int count = 1;

        while (num > cat) {
            num -= cat;
            cat *= 2;
            count++;
        }

        if (num == 0) {
            System.out.println(0);
        } else if (num == cat) {
            System.out.println(count);
        } else {
            System.out.println(count + 1);
        }
    }
}