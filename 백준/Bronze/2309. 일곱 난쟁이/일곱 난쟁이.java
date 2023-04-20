import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int[] height = new int[9];
		int sum = 0;
		int hundred = 0;
		int[] camo = new int[2];

		for (int i = 0; i < height.length; i++) {
			height[i] = scanner.nextInt();
			sum += height[i];
		}

		Arrays.sort(height);
		for (int i = 0; i < height.length - 1; i++) {
			if (hundred == 100) {
				break;
			}
			hundred = sum - height[i];
			camo[0] = i;
			for (int j = i + 1; j < height.length; j++) {
				hundred -= height[j];
				if (hundred == 100) {
					camo[1] = j;
					break;
				} else {
					hundred = sum - height[i];
					continue;
				}
			}

		}

		for (int i = 0; i < height.length; i++) {
			if (i != camo[0] && i != camo[1]) {
				System.out.println(height[i]);
			}
		}
		scanner.close();
	}
}