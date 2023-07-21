import java.io.IOException;
import java.util.Scanner;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        long N = scanner.nextLong();

        if (N == 0) {
            System.out.println(0);
        } else {
            long cat = 1L;
            int count = 1;
            while (N > cat) {
                cat *= 2;
                count++;
            }
            System.out.println(count);
        }
        scanner.close();
    }
}