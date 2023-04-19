import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		String num = scanner.nextLine();
		String[] arr = num.split(" ");
		int[] numArr = new int[2];
		for (int i = 0; i < numArr.length; i++) {
			numArr[i] = Integer.parseInt(arr[i]);
		}
		
		int[] divisor = new int[10001];
		int gcd = 0;
		int lcd = 0;

		// 최대공약수
		for (int j = 1; j <= 10000; j++) {
			if (numArr[0] % j == 0 && numArr[1] % j == 0) {
				divisor[j] = 1;
			} else {
				continue;
			}
			if (divisor[j] == 1) {
				gcd = j;
			}
		}

		// 최소공배수
		if (gcd == 1) {
			lcd = numArr[0] * numArr[1];
		} else {
			lcd = numArr[0] * (numArr[1] / gcd);
		}

		System.out.println(gcd);
		System.out.println(lcd);

		scanner.close();
	}
}