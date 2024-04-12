import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    static int n;
    static Dice[] dices;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        dices = new Dice[n];
        for (int i = 0; i < dices.length; i++) {
            dices[i] = new Dice(Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray());
        }

        int maxVal = 0;
        Dice firstDice = dices[0];
        for (int i = 0; i < firstDice.pairs.length; i++) {
            int[] pair = firstDice.pairs[i];
            for (int top : pair) {
                int sum = firstDice.maxVal[i];
                maxVal = Math.max(maxVal, stackDice(top, sum));
            }
        }

        System.out.println(maxVal);
    }

    static int stackDice(int top, int sum) {
        for (int i = 1; i < dices.length; i++) {
            int[][] pairs = dices[i].pairs;
            for (int j = 0; j < pairs.length; j++) {
                if (pairs[j][0] == top || pairs[j][1] == top) {
                    sum += dices[i].maxVal[j];
                    top = pairs[j][0] == top ? pairs[j][1] : pairs[j][0];
                    break;
                }
            }
        }

        return sum;
    }
}

class Dice {
    int[][] pairs;
    int[] maxVal;

    Dice(int[] nums) {
        pairs = new int[3][2];
        maxVal = new int[3];
        pairs[0][0] = nums[2];
        pairs[0][1] = nums[4];
        maxVal[0] = IntStream.of(new int[] { nums[0], nums[1], nums[3], nums[5] }).max().getAsInt();
        pairs[1][0] = nums[0];
        pairs[1][1] = nums[5];
        maxVal[1] = IntStream.of(new int[] { nums[1], nums[2], nums[3], nums[4] }).max().getAsInt();
        pairs[2][0] = nums[1];
        pairs[2][1] = nums[3];
        maxVal[2] = IntStream.of(new int[] { nums[0], nums[2], nums[4], nums[5] }).max().getAsInt();
    }
}