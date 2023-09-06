import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class Main {
    static int N, M;
    static int count = 0;
    static int count1;
    static int count2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Deque<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            q.add(i);
        }

        int[] targets = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int target : targets) {
            List<Integer> list1 = removeFront(q, target);
            List<Integer> list2 = removeBack(q, target);
            q = count1 < count2 ? new LinkedList<>(list1) : new LinkedList<>(list2);
            count += count1 < count2 ? count1 : count2;
        }
        System.out.println(count);
    }

    private static LinkedList<Integer> removeFront(Deque<Integer> q, int target) {
        Deque<Integer> list = new LinkedList<>(q);
        count1 = 0;
        while (list.peekFirst() != target) {
            int num = list.pollFirst();
            list.addLast(num);
            count1++;
        }
        list.pollFirst();
        return (LinkedList<Integer>) list;
    }

    private static LinkedList<Integer> removeBack(Deque<Integer> q, int target) {
        Deque<Integer> list = new LinkedList<>(q);
        count2 = 0;
        while (list.peekFirst() != target) {
            int num = list.pollLast();
            list.addFirst(num);
            count2++;
        }
        list.pollFirst();
        return (LinkedList<Integer>) list;
    }
}