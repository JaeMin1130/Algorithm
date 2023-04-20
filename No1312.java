import java.util.Scanner;

public class No1312 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String stringNum = scanner.nextLine();
        String[] numArr = stringNum.split(" ");
        double nume = (double) (Integer.parseInt(numArr[0]));
        double deno = (double) (Integer.parseInt(numArr[1]));
        double div = nume / deno;
        int n = Integer.parseInt(numArr[2]);

        for (int i = 0; i < n; i++) {
            div *= 10;
        }

        double result = div % 10;
        int count = 0;
        while (result > 1) {
            result -= 1;
            count++;
        }
        System.out.println(count);

        scanner.close();
    }
}