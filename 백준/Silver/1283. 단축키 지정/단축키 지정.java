import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        boolean[] isUsed = new boolean[91];
        for (int i = 0; i < n; i++) {
            StringBuilder input = new StringBuilder(sc.nextLine());
            boolean firstCheck = false;
            int firstIdx = 0;
            for (String str : input.toString().split(" ")) {
                firstCheck = checkChar(isUsed, input, firstIdx);
                firstIdx += str.length() + 1;
                if (firstCheck)
                    break;
            }

            if (!firstCheck) {
                for (int j = 1; j < input.length(); j++) {
                    if (checkChar(isUsed, input, j))
                        break;
                }
            }
            System.out.println(input.toString());
        }
        sc.close();

    }

    static boolean checkChar(boolean[] isUsed, StringBuilder input, int idx) {
        Character c = input.charAt(idx);
        if(c == ' ') return false;

        if (!isUsed[Character.toUpperCase(c) - '0']) {
            input.replace(idx, idx + 1, "[" + c + "]");
            isUsed[Character.toUpperCase(c) - '0'] = true;
            return true;
        }
        
        return false;
    }
}