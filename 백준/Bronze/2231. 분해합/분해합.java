import java.util.Scanner;

public class Main {
    static int constructor = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.close();

        
        hasConstructor(num);
        System.out.println(constructor == Integer.MAX_VALUE ? 0 : constructor);
    }
    
    static void hasConstructor(int num){
        int len = num / 10 + 1;
        int startNum = num - len * 9;

        if(startNum < 0) startNum = 1;
        
        for (int i = startNum; i <= num; i++) {
            int sum = i;
            String[] arr = String.valueOf(i).split("");
            for(String st : arr){
                sum += Integer.parseInt(st);
            }

            if(sum == num) constructor = Math.min(constructor, i);
        }
        
    }
}