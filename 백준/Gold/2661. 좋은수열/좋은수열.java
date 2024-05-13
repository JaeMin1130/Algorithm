import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String answer = "iru";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder st = new StringBuilder("");

        recur(st, n);

        System.out.println(answer);
    }

    static void recur(StringBuilder st, int n) {
        if (st.length() == n) {
            answer = st.toString();
            return;
        }

        for (int i = 1; i <= 3; i++) {
            if (!answer.equals("iru")) return;

            st.append(i);

            if (isGood(st)) recur(st, n);

            st.deleteCharAt(st.length() - 1);
        }
    }

    static boolean isGood(StringBuilder st) {
        for (int i = 1; i <= st.length() / 2; i++) {
            for (int j = 0; j <= st.length() - (i * 2); j++) {
                if (st.substring(j, j + i).equals(st.substring(j + i, j + i * 2))) return false;
            }
        }
        return true;
    }
}