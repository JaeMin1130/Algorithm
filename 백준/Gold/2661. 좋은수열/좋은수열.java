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

    static void recur(StringBuilder st, int n){
        if(st.length() == n){
            answer = st.toString();
            return;
        } 

        for (int i = 1; i <= 3; i++) {
            if(!answer.equals("iru")) return;
            
            st.append(i);
            
            if (isGood(st)) recur(st, n);
            
            st.deleteCharAt(st.length() - 1);
            
            if(!answer.equals("iru")) return;
        }
    }

    static boolean isGood(StringBuilder answer) {
        for (int i = 0; i < answer.length() - 1; i++) {
            for (int j = i + 1; j < answer.length(); j++) {
                if (answer.substring(i, j).equals(answer.substring(j))) return false;
            }
        }
        return true;
    }
}