import java.util.Scanner;

public class No10989 {
    static void sort() {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int list[][] = new int[10001][1000];

        for (int i = 0, j = 0; i < num; i++) {
            int value = scanner.nextInt();
            if (list[value][j] != 0 && j != 999) {
                list[value][j++ + 1] = value;

            } else {
                list[value][j++] = value;
            }
            if (j >= 1000) {
                j = 0;
            }
        }

        for (int i = 1; i < list.length; i++) {
            for (int j = 0; j < list[i].length; j++) {
                if (list[i][j] != 0) {
                    System.out.println(list[i][j]);
                }
            }
        }

        scanner.close();
    }

    public static void main(String[] args) {
        sort();
    }
}