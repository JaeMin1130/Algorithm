import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] input = new int[N];
        int[] count = new int[8001];
        double sum = 0;
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            input[i] = num;
            sum += num;
            if (num <= 0) {
                count[num * -1] += 1;
            } else {
                count[4000 + num] += 1;
            }
        }
        Arrays.sort(input);
        // System.out.println(Arrays.toString(input));
        // System.out.println("sum / N : " + sum / N);
        // System.out.println("N / 2 : " + N / 2);
        System.out.println(Math.round(sum / N));
        System.out.println(input[N / 2]);

        int[] count1 = Arrays.copyOf(count, count.length);
        Arrays.sort(count1);
        int temp = count1[count1.length - 1];
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int i = 0; i < count.length; i++) {
            if (count[i] == temp) {
                if (i >= 0 && i <= 4000) {
                    q.add(i * -1);
                } else {
                    q.add(i - 4000);
                }
            }
        }
        if (q.size() == 1) {
            System.out.println(q.poll());
        } else {
            q.poll();
            System.out.println(q.poll());
        }

        System.out.println(input[N - 1] - input[0]);
    }
}