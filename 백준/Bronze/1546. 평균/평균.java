import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		
		int num = scanner.nextInt();
		scanner.nextLine();
		String score = scanner.nextLine();
		String[] arr = score.split(" ");
		double[] scoreArr = new double[num];
		double max = 0;
		double sum = 0;

		for (int i = 0; i < num; i++) {
			scoreArr[i] = Integer.parseInt(arr[i]);
			if (scoreArr[i] > max) {
				max = scoreArr[i];
			}
		}
		for (int i = 0; i < num; i++) {
			scoreArr[i] = (scoreArr[i] / max) * 100;
			sum += scoreArr[i];
		}

		System.out.println(sum / num);
		scanner.close();
	}
}