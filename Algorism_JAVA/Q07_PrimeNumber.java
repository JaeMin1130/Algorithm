import java.util.Scanner;

public class Q07_PrimeNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 나의 답안
        System.out.println("<나의 답안>");
        System.out.println("수를 입력하세요.");
        int num1 = scanner.nextInt();
        int[] divNum = new int[1000];

        // 약수 찾기
        for (int i = 1; i <= num1; i++) {
            if (num1 % i == 0) {
                divNum[i] = num1 / i;
            }
        }

        // 소수 판별
        for (int i = 2; i <= num1; i++) {
            if (divNum[i] != 0 && i < num1) {
                System.out.println(num1 + "은(는) 소수가 아닙니다." + "(" + divNum[i] + "로 나눠짐)");
                break;
            } else if (divNum[i] == 0) {
                continue;
            } else {
                System.out.println(num1 + "은(는) 소수입니다.");
            }
        }

        // 선생님의 답안
        System.out.println("<선생님의 답안>");
        System.out.println("수를 입력하세요.");
        int num2 = scanner.nextInt();
        boolean isPrimeNumber = true;
        int div = 0;

        for (int i = 2; i <= num2 / 2; i++) { // num/2 보다 큰 수로 나누면 무조건 나머지가 생긴다.
            if (num2 % i == 0) {
                div = i;
                isPrimeNumber = false;
                break;
            }
        }
        if (isPrimeNumber) {
            System.out.println(num2 + "은(는) 소수입니다.");
        } else {
            System.out.println(num2 + "은(는) 소수가 아닙니다." + "(" + div + "로 나눠짐)");
        }
        scanner.close();
    }
}