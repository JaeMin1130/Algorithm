import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Queue {
    List<Integer> list;

    Queue() {
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

    void push(int X) {
        list.add(X);
    }

    int pop() {
        if (list.isEmpty()) {
            return -1;
        }
        int num = list.get(0);
        list.remove(0);
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
        Queue deque = new Queue();
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            switch (input[0]) {
                case "push":
                    deque.push(Integer.parseInt(input[1]));
                    break;
                case "front":
                    System.out.println(deque.front());
                    break;
                case "back":
                    System.out.println(deque.back());
                    break;
                case "pop":
                    System.out.println(deque.pop());
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