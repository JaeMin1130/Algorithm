import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();
        char[] wordArr = word.toCharArray();
        int[] alphabetArr = new int[26];
        int max = 0;
        int index = 0;
        int count = 0;

        for (int i = 0; i < wordArr.length; i++) {
            if (wordArr[i] - 0 < 97) {
                alphabetArr[wordArr[i] - 65] += 1;
            } else {
                alphabetArr[wordArr[i] - 97] += 1;
            }
        }

        for (int i = 0; i < alphabetArr.length; i++) {
            if (alphabetArr[i] > max) {
                max = alphabetArr[i];
                index = i;
            }
        }
        for (int i = 0; i < alphabetArr.length; i++) {
            if (alphabetArr[i] == max) {
                count++;
            }
        }
        if (count == 1) {
            System.out.println(Character.toChars(index + 65));
        } else {
            System.out.println("?");
        }
        scanner.close();
    }
}