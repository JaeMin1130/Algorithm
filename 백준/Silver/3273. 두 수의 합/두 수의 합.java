import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Integer[] arr = Stream.of(br.readLine().split(" "))
                .map(Integer::valueOf)
                .toArray(Integer[]::new);

        Arrays.sort(arr, Comparator.reverseOrder());

        int target = Integer.parseInt(br.readLine());
        int count = findPairsWithSum(arr, target);
        System.out.println(count);
    }

    private static int findPairsWithSum(Integer[] arr, int target) {
        Set<Integer> seen = new HashSet<>();
        int count = 0;

        for (int num : arr) {
            int complement = target - num;
            if (seen.contains(complement)) {
                count++;
            }
            seen.add(num);
        }

        return count;
    }
}