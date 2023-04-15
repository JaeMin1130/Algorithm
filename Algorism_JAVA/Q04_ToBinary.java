import java.util.ArrayList;
import java.util.Scanner;

public class Q04_ToBinary {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        ArrayList<Integer> list = new ArrayList<Integer>();
        int i = 0;

        while (input != 0) {
            int quotient = input / 2;
            int remainder = input % 2;
            input = quotient;
            list.add(remainder);
            if (quotient == 0)
                break;
            i++;
        }
        
        for (int j = i; j >= 0; j--) {
            System.out.print(list.get(j));
        }
        scanner.close();
    }
}