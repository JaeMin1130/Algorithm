import java.util.Scanner;

public class Main {
    static void biCoefficient() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int nume = 1;
        int deno = 1;
        for (int i = 0; i < k; i++) {
            nume *= n - i;
            deno *= k - i;
        }
        System.out.println(nume / deno);
        scanner.close();
    }

    public static void main(String[] args) {
        biCoefficient();
    }
}