import java.util.Arrays;
import java.util.Scanner;

public class Q03_Mode {
    public static void main(String[] args) {

        // 숫자 입렵 받아 배열 생성
        Scanner scanner = new Scanner(System.in);
        int[] inputNum = new int[10];
        System.out.println("type a number");
        for (int i = 0; i < 10; i++) {
            inputNum[i] = scanner.nextInt();
        }

        // index로 최빈값을 표시하는 배열 생성
        int[] mode = new int[10];
        for (int i = 0; i < 10; i++) {
            int index = inputNum[i];
            mode[index] += 1;
        }

        // 값이 제일 큰 인덱스 찾기
        // 방법 1
        int modeNum = 0; // 최빈수
        int modeCnt = 0; // 최빈수가 나온 횟수
        for (int i = 0; i < 10; i++) {
            if (mode[i] > modeCnt) {
                modeCnt = mode[i];
                modeNum = i;
            }
        }
        System.out.println(modeNum + ", " + modeCnt + "회");

        // 방법 2
        int max = Arrays.stream(mode).max().getAsInt();
        for (int i = 0; i < 10; i++) {
            if (mode[i] == max) {
                System.out.println("최빈값 : " + i + ", " + max + "회");
            }
        }
        scanner.close();
    }
}