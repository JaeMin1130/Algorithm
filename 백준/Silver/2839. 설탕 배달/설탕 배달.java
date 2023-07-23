import java.io.IOException;
import java.util.Scanner;

class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        int sugar = scanner.nextInt();

        int env5 = sugar / 5;
        int env3 = 0;
        int rest = sugar - env5 * 5;
        boolean flag = false;

        if (sugar % 5 == 0) {
            System.out.println(sugar / 5);
        } else {
            while (env5 >= 0) {
                if (rest % 3 == 0) {
                    env3 = rest / 3;
                    flag = true;
                    break;
                } else {
                    env5 -= 1;
                    rest += 5;
                }
            }

            if (flag) {
                System.out.println(env3 + env5);
            } else {
                System.out.println(-1);
            }
        }

        scanner.close();
    }
}
