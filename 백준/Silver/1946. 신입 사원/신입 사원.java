import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            Applicant[] arr = new Applicant[n];
            for (int j = 0; j < n; j++) {
                String[] input = br.readLine().split(" ");
                int resume = Integer.parseInt(input[0]);
                int interview = Integer.parseInt(input[1]);
                arr[j] = new Applicant(resume, interview);
            }
            Arrays.sort(arr, (a1, a2) -> a1.resume - a2.resume);
            int count = n; 
            int minInterview = arr[0].interview;
            for (int j = 1; j < arr.length; j++) {
                if (arr[j].interview > minInterview) {
                    count--;
                }
                minInterview = Math.min(arr[j].interview, minInterview);
            }
            System.out.println(count);
        }
    }
}

class Applicant {
    int resume;
    int interview;

    Applicant(int resume, int interview) {
        this.resume = resume;
        this.interview = interview;
    }

    public String toString() {
        return String.format("(%s, %s)", resume, interview);
    }
}
