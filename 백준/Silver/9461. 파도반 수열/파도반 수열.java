import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ArrayList<Long> list = new ArrayList<>(Arrays.asList(1L, 1L, 1L, 2L, 2L, 3L, 4L, 5L, 7L, 9L));
        for (int i = 5; i <= 94; i++) {
            list.add(list.get(i) + list.get(i + 4));
        }
        
        for (int i = 0; i < N; i++) {
            System.out.println(list.get(Integer.parseInt(br.readLine()) - 1));
        }
    }
}