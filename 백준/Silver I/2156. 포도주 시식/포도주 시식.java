import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();
		int[] wines = new int[n + 1];
		int[] memo = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			wines[i] = scanner.nextInt();
		}

		scanner.close();

		memo[1] = wines[1];
		if (n > 1) {
			memo[2] = wines[1] + wines[2];
		}

		for (int i = 3; i <= n; i++) {
			memo[i] = Math.max(Math.max(memo[i - 1], memo[i - 2] + wines[i]), memo[i - 3] + wines[i - 1] + wines[i]);
		}

		System.out.println(memo[n]);
	}
}