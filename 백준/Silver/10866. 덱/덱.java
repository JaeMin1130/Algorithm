import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Deque {
    List<Integer> list;

    Deque() {
        list = new ArrayList<>();
    }

    int empty() {
        if (list.isEmpty()) {
            return 1;
        }
        return 0;
    }

    int size() {
        return list.size();
    }

    void push_front(int X) {
        List<Integer> list = new ArrayList<>(Arrays.asList(X));
        for (Integer num : this.list) {
            list.add(num);
        }
        this.list = new ArrayList<>(list);
    }

    void push_back(int X) {
        this.list.add(X);
    }

    int pop_front() {
        if (list.isEmpty()) {
            return -1;
        }
        int num = list.get(0);
        list.remove(0);
        return num;
    }

    int pop_back() {
        if (list.isEmpty()) {
            return -1;
        }
        int idx = list.size() - 1;
        int num = list.get(idx);
        list.remove(idx);
        return num;
    }

    int front() {
        if (list.isEmpty()) {
            return -1;
        }
        return list.get(0);
    }

    int back() {
        if (list.isEmpty()) {
            return -1;
        }
        return list.get(list.size() - 1);
    }
}

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Deque deque = new Deque();
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            switch (input[0]) {
                case "push_front":
                    deque.push_front(Integer.parseInt(input[1]));
                    break;
                case "push_back":
                    deque.push_back(Integer.parseInt(input[1]));
                    break;
                case "front":
                    System.out.println(deque.front());
                    break;
                case "back":
                    System.out.println(deque.back());
                    break;
                case "pop_front":
                    System.out.println(deque.pop_front());
                    break;
                case "pop_back":
                    System.out.println(deque.pop_back());
                    break;
                case "empty":
                    System.out.println(deque.empty());
                    break;
                case "size":
                    System.out.println(deque.size());
                    break;
                default:
                    break;
            }
        }
    }
}