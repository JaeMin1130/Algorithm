import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        HashMap<String, Double> creditMap = new HashMap<>();
        String[] creditStr = { "A+", "A0", "B+", "B0", "C+", "C0", "D+", "D0", "F" };
        Double[] creditNum = { 4.5, 4.0, 3.5, 3.0, 2.5, 2.0, 1.5, 1.0, 0.0 };
        for (int i = 0; i < creditNum.length; i++) {
            creditMap.put(creditStr[i], creditNum[i]);
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double scoreSum = 0;
        double creditSum = 0;
        for (int i = 0; i < 20; i++) {
            String[] input = br.readLine().split(" ");
            if (!input[2].equals("P")) {
                scoreSum += Double.parseDouble(input[1]) * creditMap.get(input[2]);
                creditSum += Double.parseDouble(input[1]);
            }
        }
        System.out.println(String.format("%.6f", scoreSum / creditSum));
    }
}