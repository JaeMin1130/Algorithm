import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String dice = scanner.nextLine();
        String[] arr = dice.split(" ");
        int[] intArr = new int[3];
        for (int i = 0; i < arr.length; i++) {
            intArr[i] = Integer.parseInt(arr[i]);
        }
        int num = 0;
        int count = 0;
        int max = 0;

        if (intArr[1] == intArr[0] && intArr[1] == intArr[2]) {
            count = 3;
            num = intArr[1];
        }else if(intArr[1] != intArr[0] && intArr[1] == intArr[2]){
            count = 2;
            num = intArr[1];
        }else if (intArr[1] == intArr[0] && intArr[1] != intArr[2]) {
            count = 2;
            num = intArr[1];
        } else if (intArr[2] == intArr[0] && intArr[1] != intArr[2]) {
            count = 2;
            num = intArr[2];
        }
        for (int i = 0; i < intArr.length; i++) {
            if (intArr[i] > max) {
                max = intArr[i];
            }
        }

        if (count == 3) {
            System.out.println(10000 + 1000 * num);
        } else if (count == 2) {
            System.out.println(1000 + 100 * num);
        } else {
            System.out.println(100 * max);
        }
    }
}