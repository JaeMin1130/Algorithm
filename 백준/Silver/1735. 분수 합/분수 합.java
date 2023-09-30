import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] fraction1 = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] fraction2 = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int nume = fraction1[0] * fraction2[1] + fraction2[0] * fraction1[1];
        int deno = fraction1[1] * fraction2[1];
        int gcdVal = gcd(deno, nume);
        nume /= gcdVal;
        deno /= gcdVal;
        System.out.println(nume + " " + deno);
    }

    static int gcd(int nume, int deno) {
        if (deno == 0)
            return nume;
        else
            return gcd(deno, nume % deno);
    }
}