import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        boolean[] isPrime = new boolean[1004000];
        checkPrime(isPrime);

        for (int i = n; i < isPrime.length; i++) {
            if(!isPrime[i]) continue;
            if(!checkPelin(new StringBuilder(String.valueOf(i)))) continue;
            System.out.println(i);
            break;
        }
    }
    
    static void checkPrime(boolean[] isPrime){
        Arrays.fill(isPrime, true);
        isPrime[1] = false;

        for (int i = 2; i < Math.sqrt(isPrime.length); i++) {
            if(!isPrime[i]) continue;
            for (int j = i * i; j < isPrime.length; j += i) {
                isPrime[j] = false;
            }
        }
    }

    static boolean checkPelin(StringBuilder num){
        
        String front = num.substring(0, num.length() / 2);
        String back = num.reverse().substring(0, num.length() / 2);
        
        if(front.equals(back)) return true;

        return false;
    }
}