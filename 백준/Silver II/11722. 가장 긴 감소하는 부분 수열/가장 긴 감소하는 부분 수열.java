import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] arr = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		int[] memo = new int[n];
		Arrays.fill(memo, 1);

		for (int i = n - 2; i >= 0; i--) {
			for (int j = i + 1; j < n; j++) {
				if (arr[i] > arr[j]) {
					memo[i] = Math.max(memo[j] + 1, memo[i]);
				}
			}
		}

		int max = 0;
		for (int num : memo) {
			if (num > max) {
				max = num;
			}
		}

		System.out.println(max);
	}
}