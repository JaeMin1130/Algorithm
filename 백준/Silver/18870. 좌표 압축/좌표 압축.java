import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer input = new StringTokenizer(br.readLine());

        Integer[] arr = new Integer[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.valueOf(input.nextToken());
        }
        Set<Integer> set = new HashSet<>(Arrays.asList((arr)));
        Object[] setArr = set.toArray();
        Arrays.sort(setArr);

        StringBuilder result = new StringBuilder();

        for (Integer i : arr) {
            int idx = Arrays.binarySearch(setArr, i);
            result.append(idx + " ");
        }
        System.out.println(result);
    }
}