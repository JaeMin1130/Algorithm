import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split("");
        double[] nums = new double[10];

        for (String str : input) {
            int num = Integer.parseInt(str);
            if (num == 6 || num == 9) {
                nums[6] += 0.5;
            } else {
                nums[num]++;
            }
        }
        Arrays.sort(nums);
        System.out.println(Math.round(nums[9]));
    }
}