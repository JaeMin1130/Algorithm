import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        PriorityQueue<String> q = new PriorityQueue<>((s1, s2) -> s1.compareTo(s2));
        for (int i = 0; i < word.length(); i++) {
            q.add(word.substring(i, word.length()));
        }
        while (!q.isEmpty()) {
            System.out.println(q.poll());
        }
    }
}