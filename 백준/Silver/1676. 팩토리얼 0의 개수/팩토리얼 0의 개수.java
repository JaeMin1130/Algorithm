import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int count2 = 0;
        int count5 = 0;
        for (int i = num; i > 0; i--) {
            int value = i;
            while (value % 2 == 0 || value % 5 == 0) {
                if (value % 2 == 0) {
                    value = value / 2;
                    count2++;
                }
                if (value % 5 == 0) {
                    value = value / 5;
                    count5++;
                }
            }
        }
        if (count2 <= count5)
            System.out.println(count2);
        else
            System.out.println(count5);
        scanner.close();
    }
}