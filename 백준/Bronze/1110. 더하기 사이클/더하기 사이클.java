import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int num = scanner.nextInt();
		int num1 = 0;
		int num2 = 0;
		int[] numDiv = new int[3];
		int count = 1;

		if (num < 10) {
			num1 = 0;
		} else {
			num1 = num / 10;
		}
		num2 = num % 10;

		numDiv[0] = num1;
		numDiv[1] = num2;

		while (true) {
			numDiv[2] = (numDiv[0] + numDiv[1]) % 10;
			if (numDiv[1] == num1 && numDiv[2] == num2) {
				break;
			}
			numDiv[0] = numDiv[1];
			numDiv[1] = numDiv[2];
			count++;
		}
		System.out.println(count);
		scanner.close();
	}
}