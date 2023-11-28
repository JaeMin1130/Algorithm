import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class Main{
    public static void main(String[] args) throws NumberFormatException, IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] roads = Stream.of(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        int[] cities = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        
        long sum = 0L;
        for (int i = 0; i < cities.length - 1; i++) {
            int count = checkPrice(i, cities);
            int price = cities[i];
            for (int j = i; j <= i + count; j++) {
                sum += price * roads[j];
            }
            i += count;
        }

        System.out.println(sum);

    }

    static int checkPrice(int curLocation, int[] cities){

        int count = 0;

        for (int i = curLocation + 1; i < cities.length - 1; i++) {
            if(cities[curLocation] <= cities[i]){
                count++;
            }else{
                break;
            }
        }

        return count;

    }

}