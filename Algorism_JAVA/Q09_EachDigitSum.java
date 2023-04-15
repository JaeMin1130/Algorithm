import java.util.Scanner;

public class Q09_EachDigitSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // My answer
        System.out.println("수를 입력하세요.");
        String num1 = scanner.next();
        char[] digitArr = num1.toCharArray();
        int digitSum1 = 0;

        for (int i = 0; i < digitArr.length; i++) {
            digitSum1 += Character.getNumericValue(digitArr[i]);
        }
        System.out.println("각 자릿수의 합 = " + digitSum1);

        // Teacher's answer
        System.out.println("수를 입력하세요.");
        int num2 = scanner.nextInt();
        int digitsum2 = 0;

        while (num2 > 0) {
            digitsum2 += num2 % 10;
            num2 /= 10;
        }
        System.out.println("각 자릿수의 합 = " + digitsum2);
        scanner.close();
    }
}