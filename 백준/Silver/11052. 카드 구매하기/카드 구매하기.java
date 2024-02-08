import java.util.Scanner;

public class Main {

	static int[] memo;
	static int[] prices;

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int n = Integer.parseInt(scanner.nextLine());

		prices = new int[n + 1];
		for (int i = 1; i < prices.length; i++) {
			prices[i] = scanner.nextInt();
		}

		scanner.close();

		memo = new int[1001];
		memo[1] = prices[1];

		for (int i = 2; i <= n; i++) {
			for (int j = 1; j <= i / 2; j++) {
				memo[i] = Math.max(memo[i - j] + memo[j], memo[i]);
			}
			memo[i] = Math.max(prices[i], memo[i]);
		}

		System.out.println(memo[n]);
	}

}