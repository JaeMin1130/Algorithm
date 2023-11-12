import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        String word = scanner.next();

        int[] countAlphabet = new int[26];
        for (char alphabet : word.toCharArray()) {
            countAlphabet[alphabet - 'a']++;
        }

        for (int num : countAlphabet) {
            System.out.print(num + " ");
        }

        scanner.close();
    }
}