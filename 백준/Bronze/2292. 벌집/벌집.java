import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.close();

        int idx = 1;
        int prevNum = 1;

        while (prevNum < num) {
            prevNum += 6 * idx++;
        }

        System.out.println(idx);
    }
}