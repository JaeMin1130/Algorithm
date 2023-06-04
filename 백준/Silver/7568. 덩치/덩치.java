import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;

class Size {
    int weight;
    int height;
    int count;
    int rank;

    Size(int weight, int height) {
        this.weight = weight;
        this.height = height;
        count = 0; // 나보다 덩치 큰 사람 수
    }
}

class SizeComparator implements Comparator<Size> {
    public int compare(Size s1, Size s2) {
        int value1 = s1.weight - s2.weight;
        int value2 = s1.height - s2.height;
        if (value1 > 0 && value2 > 0)
            return 1;
        else if (value1 < 0 && value2 < 0)
            return 2;
        else
            return 0;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Size[] list = new Size[N];
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            list[i] = new Size(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
        }

        SizeComparator com = new SizeComparator();
        for (int i = 0; i < list.length - 1; i++) {
            for (int j = i + 1; j < list.length; j++) {
                if (com.compare(list[i], list[j]) == 1)
                    list[j].count++;
                else if (com.compare(list[i], list[j]) == 2)
                    list[i].count++;
            }
        }
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i].count + 1 + " ");
        }
    }
}