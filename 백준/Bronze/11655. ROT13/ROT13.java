import java.util.Scanner;

class ROT {
    String sentence;

    ROT() {
        Scanner scanner = new Scanner(System.in);
        sentence = scanner.nextLine();
        scanner.close();
    }

    public void ROT13(String sentence) {
        char[] arr = sentence.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 65 && arr[i] <= 90) {
                if (arr[i] + 13 > 90) {
                    arr[i] = (char) (arr[i] - 13);
                } else {
                    arr[i] = (char) (arr[i] + 13);
                }
            } else if (arr[i] >= 97 && arr[i] <= 122) {
                if (arr[i] + 13 > 122) {
                    arr[i] = (char) (arr[i] - 13);
                } else {
                    arr[i] = (char) (arr[i] + 13);
                }
            }
            System.out.print(arr[i]);
        }
    }
}

public class Main {

    public static void main(String[] args) {
        ROT execute = new ROT();
        execute.ROT13(execute.sentence);
    }
}