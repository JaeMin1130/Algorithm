import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    static Set<Integer> set = new HashSet<>();

    public static void add(int x) {
        set.add(x);
    }

    public static void remove(int x) {
        try {
            set.remove(x);
        } catch (Exception e) {
        }
    }

    public static void toggle(int x) {
        if (set.contains(x)) {
            set.remove(x);
        } else {
            set.add(x);
        }
    }

    public static void all() {
        set.clear();
        for (int i = 1; i <= 20; i++) {
            set.add(i);
        }
    }

    public static void empty() {
        set.clear();
    }

    public static String check(int x) {
        if (set.contains(x))
            return "1\n";
        else
            return "0\n";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        StringBuilder result = new StringBuilder("");
        for (int i = 0; i < M; i++) {
            String[] input = br.readLine().split(" ");
            String name = input[0];
            int x = 0;
            if (input.length == 2) {
                x = Integer.parseInt(input[1]);
            }
            switch (name) {
                case "add":
                    add(x);
                    break;
                case "remove":
                    remove(x);
                    break;
                case "toggle":
                    toggle(x);
                    break;
                case "all":
                    all();
                    break;
                case "empty":
                    empty();
                    break;
                case "check":
                    result.append(check(x));
                    break;
            }
        }
        System.out.println(result);
    }
}