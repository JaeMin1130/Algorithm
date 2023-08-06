import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack stack = new Stack();
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            switch (input[0]) {
                case "push":
                    stack.push(Integer.parseInt(input[1]));
                    break;
                case "top":
                    System.out.println(stack.top());
                    break;
                case "size":
                    System.out.println(stack.size());
                    break;
                case "empty":
                    System.out.println(stack.empty());
                    break;
                case "pop":
                    System.out.println(stack.pop());
                    break;
                default:
                    break;
            }
        }
    }

}

class Stack {
    ArrayList<Integer> list;

    Stack() {
        list = new ArrayList<>();
    }

    void push(int X) {
        list.add(X);
    }

    int pop() {
        if (list.isEmpty()) {
            return -1;
        } else {
            int idx = list.size() - 1;
            int num = list.get(idx);
            list.remove(idx);
            return num;
        }
    }

    int size() {
        return list.size();
    }

    int empty() {
        if (list.isEmpty()) {
            return 1;
        } else {
            return 0;
        }
    }

    int top() {
        if (list.isEmpty()) {
            return -1;
        } else {
            return list.get(list.size() - 1);
        }
    }

}