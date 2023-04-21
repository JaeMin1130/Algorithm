import java.math.BigDecimal;
import java.util.Scanner;

public class No1312 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String stringNum = scanner.nextLine();
        String[] numArr = stringNum.split(" ");
        BigDecimal nume = new BigDecimal(Integer.parseInt(numArr[0]));
        BigDecimal deno = new BigDecimal(Integer.parseInt(numArr[1]));
        int count = 0;
        int result = 1;
        int n = Integer.parseInt(numArr[2]);
        BigDecimal div = nume.divide(deno, n, BigDecimal.ROUND_DOWN);

        
        for (int i = 0; i < n; i++) {
            if (count == n) {
                break;
            }
            div = div.remainder(new BigDecimal(10));
            div = div.multiply(new BigDecimal(10));
            div = div.remainder(new BigDecimal(10));
            count++;
        }

        while (div.compareTo(new BigDecimal(1)) > 0) {
            div = div.subtract(new BigDecimal(1));
            result++;
        }
        System.out.println(result);

        scanner.close();
    }
}