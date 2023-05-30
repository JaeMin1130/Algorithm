import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        LinkedList<Integer> list = new LinkedList<Integer>();

        for (int i = 1; i <= num; i++) {
            list.add(i);
        }

        while (list.size() != 1) {
            list.remove(0);
            if (list.size() == 1)
                break;
            list.add(list.get(0));
            list.remove(0);
        }

        System.out.println(list.get(0));
        scanner.close();
    }
}