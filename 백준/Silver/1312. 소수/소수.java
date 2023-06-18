import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        
        Scanner scanner = new Scanner(System.in);
        double A = scanner.nextDouble();
        double B = scanner.nextDouble();
        int N = scanner.nextInt();
        int count = 0;
        int result = 0;

        while (count < N) {
            result = (int) (A / B * 10 % 10);
            A = A % B * 10;
            count++;
        }

        System.out.println(result);
        scanner.close();
    }
}