import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.stream.Stream;

class Main {
    static ArrayList<ArrayList<Integer>> rectangle = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < input[0]; i++) {
            int[] line = Stream.of(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
            ArrayList<Integer> arr = new ArrayList<>();
            for (int j = 0; j < line.length; j++) {
                arr.add(line[j]);
            }
            rectangle.add(arr);
        }

        int len = 1;
        int width = 1;

        for (int i = 0; i < rectangle.size() - 1; i++) {
            ArrayList<Integer> line = rectangle.get(i);
            for (int j = 0; j < line.size() - 1; j++) {
                for (int k = j + 1; k < line.size(); k++) {
                    if (line.get(k) == line.get(j)) {
                        len = k - j + 1;
                        if (checkSquare(len, i, j, k, line.get(j))) {
                            int temp = len * len;
                            if (temp > width) {
                                width = temp;
                            }
                        }
                    }
                }
            }
        }
        System.out.println(width);
    }

    static boolean checkSquare(int len, int startLine, int idx1, int idx2, int val) {
        int endLine = startLine + len - 1;
        if (endLine < rectangle.size()) {
            ArrayList<Integer> line = rectangle.get(endLine);
            if (line.get(idx1) == val && line.get(idx2) == val) {
                return true;
            }
        }
        return false;
    }
}