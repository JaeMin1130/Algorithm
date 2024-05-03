import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int hole;
    static int n;
    static int[] pieces;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try{
                hole = Integer.parseInt(br.readLine()) * 10000000;
            }catch(Exception e){
                return;
            }

            n = Integer.parseInt(br.readLine());
            pieces = new int[n];
            for (int i = 0; i < pieces.length; i++) {
                pieces[i] = Integer.parseInt(br.readLine());
            }
            Arrays.sort(pieces);

            int startIdx = 0;
            int endIdx = n - 1;
            int startNum = 0;
            int endNum = 0;
            while (endIdx > startIdx) {
                startNum = pieces[startIdx];
                endNum = pieces[endIdx];
                if (startNum + endNum > hole) endIdx--;
                else if (startNum + endNum < hole) startIdx++;
                else break;
            }

            if (startNum + endNum == hole) {
                System.out.printf("%s %d %d\n", "yes", startNum, endNum);
            } else {
                System.out.println("danger");
            }

        }
    }
}