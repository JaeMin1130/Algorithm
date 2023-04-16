import java.util.Scanner;

public class Q21_DuplicateNum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("수를 입력하세요,");
        String num = scanner.next();
        String[] numArr = num.split(",");
        int[] intArr = new int[100];

        // String 배열 -> int 배열
        for (int i = 0; i < numArr.length; i++) {
            intArr[i] = Integer.parseInt(numArr[i]);
        }

        boolean[] exist = new boolean[101];

        // intArr[]에서 두 번 나온 값을 exist[]의 인덱스로 넣어서 exist[intArr[i]] = true
        for (int i = 0, k = 1; i < intArr.length; i++, k++) {
            for (int j = k; j < intArr.length; j++) {
                if (intArr[i] == intArr[j]) {
                    exist[intArr[i]] = true;
                    continue;
                }
            }
        }

        // true인 인덱스 번호 출력
        for (int j = 1; j < exist.length; j++) {
            if (exist[j] == true) {
                System.out.print(j + " ");
            }
        }
        scanner.close();
    }
}