import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Stream;

public class Main {

	static int[] input;
	static int[] memo;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int length = Integer.parseInt(br.readLine());
		input = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		memo = new int[length];

		dp();

		int answer = Arrays.stream(memo).max().orElse(0);

		System.out.println(answer);
	}

	static void dp() {
		for (int i = 0; i < input.length; i++) {
			memo[i] = input[i];
			for (int j = 0; j < i; j++) {
				if (input[j] < input[i] && memo[i] < memo[j] + input[i]) {
					memo[i] = memo[j] + input[i];
				}
			}
		}
	}
}