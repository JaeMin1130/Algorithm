import java.util.Scanner;

public class Q22_Palindrome {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("수를 입력하세요,");
        String num = scanner.next();
        char[] numArr = num.toCharArray();

        int n = numArr.length / 2;
        int check = 0;

        if (numArr.length % 2 == 1) {
            for (int i = 1; i <= n; i++) {
                if (numArr[n - i] == numArr[n + i]) {
                    check++;
                }
            }
            if (check == n) {
                System.out.println("Palindrome");
            } else {
                System.out.println("Not Palindrome");
            }
        }
        scanner.close();
    }
}