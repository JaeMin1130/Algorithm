import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Grade implements Comparable<Grade> {
    String name;
    int korean;
    int math;
    int english;

    Grade(String name, int korean, int english, int math) {
        this.name = name;
        this.korean = korean;
        this.english = english;
        this.math = math;
    }

    @Override
    public int compareTo(Grade g) {
        if (this.korean != g.korean) {
            return g.korean - this.korean;
        } else if (this.english != g.english) {
            return this.english - g.english;
        } else if (this.math != g.math) {
            return g.math - this.math;
        } else {
            return this.name.compareTo(g.name);
        }
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Grade[] arr = new Grade[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer input = new StringTokenizer(br.readLine());
            arr[i] = new Grade(input.nextToken(), Integer.parseInt(input.nextToken()),
                    Integer.parseInt(input.nextToken()), Integer.parseInt(input.nextToken()));
        }
        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i].name);
        }
    }
}
