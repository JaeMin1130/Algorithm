import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        Integer[] arr = Stream.of(input.split("")).map(Integer::valueOf).toArray(Integer[]::new);
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        
        if (input.contains("0") && sum % 3 == 0) {
            Arrays.sort(arr, Comparator.reverseOrder());
            for (Integer num : arr) {
                System.out.print(String.valueOf(num));
            }
        } else {
            System.out.println(-1);
        }
    }
}