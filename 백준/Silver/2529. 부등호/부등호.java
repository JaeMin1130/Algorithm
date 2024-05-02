import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static String[] input;
    static int[] temp;
    static List<int[]> list = new ArrayList<>();

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(br.readLine());
        input = br.readLine().split(" ");
        permutation(0, new int[k + 1], new boolean[10], false);

        for (int digit : list.get(list.size() - 1)) {
            System.out.print(digit);
        }

        System.out.println();

        for (int digit : list.get(0)) {
            System.out.print(digit);
        }
    }

    static void permutation(int idx, int[] arr, boolean[] isUsed, boolean flag) {
        if (flag) return;

        if (idx == arr.length) {
            if (isTrue(input, arr)) {
                list.add(arr);
            }
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (flag) return;
            if (isUsed[i]) continue;
            arr[idx] = i;
            isUsed[i] = true;
            permutation(idx + 1, arr.clone(), isUsed.clone(), flag);
            isUsed[i] = false;
        }
        if (flag) return;
    }

    static boolean isTrue(String[] input, int[] arr) {
        boolean result = false;
        for (int i = 0; i < arr.length - 1; i++) {
            if (input[i].equals("<")) {
                result = arr[i] < arr[i + 1];
            } else {
                result = arr[i] > arr[i + 1];
            }

            if (!result) return result;
        }
        return result;
    }
}