import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int caseNum = scanner.nextInt();
        scanner.nextLine();
        String[] caseArr = new String[caseNum];
        for (int i = 0; i < caseNum; i++) {
            caseArr[i] = scanner.nextLine();
        }

        double sum = 0;
        for (int i = 0; i < caseArr.length; i++) {
            String[] eachCase = caseArr[i].split(" ");
            double[] arr = new double[eachCase.length];
            for (int j = 0; j < eachCase.length; j++) {
                arr[j] = Double.parseDouble(eachCase[j]);
                if (j > 0) {
                    sum += arr[j];
                }
            }
            double avg = sum / arr[0];
            int count = 0;
            for (int j = 1; j < arr.length; j++) {
                if (arr[j] > avg) {
                    count++;
                }
            }
            String result = String.format("%.3f", ((count / arr[0]) * 100));
            System.out.println(result + "%");
            count = 0;
            sum = 0;
        }
    scanner.close();
    }
}