import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String info = scanner.nextLine();
        String[] infoArr = info.split(" ");

        int A = Integer.parseInt(infoArr[0]);
        int B = Integer.parseInt(infoArr[1]);
        int V = Integer.parseInt(infoArr[2]);
        int day = 0;

        if ((V - A) % (A - B) == 0) {
            day = (V - A) / (A - B) + 1;
        } else {
            day = (V - A) / (A - B) + 2;
        }
        System.out.println(day);

        scanner.close();
    }
}