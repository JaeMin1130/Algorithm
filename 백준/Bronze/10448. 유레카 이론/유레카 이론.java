import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        ArrayList<Integer> triNum = new ArrayList<Integer>();
        int i = 1;
        while (i * (i + 1) / 2 < 999) {
            triNum.add(i * (i + 1) / 2);
            i++;
        }
        int sub = 0;
        boolean flag = true;
        for (i = 0; i < num; i++) {
            int input = scanner.nextInt();
            for (int j1 = 0; j1 < triNum.size(); j1++) {
                if (!flag)
                    break;
                for (int j2 = 0; j2 < triNum.size(); j2++) {
                    if (!flag)
                        break;
                    for (int j3 = 0; j3 < triNum.size(); j3++) {
                        sub = input - (triNum.get(j1) + triNum.get(j2) + triNum.get(j3));
                        if (sub == 0) {
                            System.out.println(1);
                            flag = false;
                            break;
                        }
                    }
                }
            }
            if (flag) {
                System.out.println(0);
            } else {
                flag = true;
            }
        }
        scanner.close();
    }
}