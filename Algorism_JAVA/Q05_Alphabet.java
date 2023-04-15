import java.util.ArrayList;
import java.util.Scanner;

public class Q05_Alphabet {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("변환할 단어를 입력하세요.");
        String input = scanner.next();

        char[] arr = input.toCharArray();
        ArrayList<Character> newArray = new ArrayList<Character>();

        for (int i = 0; i < arr.length; i++) {
            if ('A' <= arr[i] && arr[i] <= 'Z') {
                newArray.add((char) (arr[i] + 32));
            } else if (arr[i] >= 'a') {
                newArray.add((char) (arr[i] - 32));
            }
            System.out.print(newArray.get(i));
        }
        scanner.close();
    }
}