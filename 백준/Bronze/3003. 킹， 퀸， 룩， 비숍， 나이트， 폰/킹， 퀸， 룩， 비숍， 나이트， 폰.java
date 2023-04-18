import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String num = scanner.nextLine();
        String[] numArr = num.split(" ");

        int[] intArr = new int[6];
        for (int i = 0; i < numArr.length; i++) {
            intArr[i] = Integer.parseInt(numArr[i]);
        }

        int[] fill = new int[6];
        for (int i = 0; i <= 1; i++) {
            if (intArr[i] != 1) {
                fill[i] = 1 - intArr[i];
            }
        }
        for (int i = 2; i <= 4; i++) {
            if (intArr[i] != 2) {
                fill[i] = 2 - intArr[i];
            }
        }
        if (intArr[5] != 8) {
            fill[5] = 8 - intArr[5];
        }

        for (int i = 0; i < fill.length; i++) {
            System.out.print(fill[i]);
            if(i != 5){
                System.out.print(" ");
            }
        }
        scanner.close();
    }
}