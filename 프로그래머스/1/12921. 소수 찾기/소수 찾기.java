import java.util.*;
import java.util.stream.IntStream;

class Solution {
    public int solution(int n) {
        boolean[] isPrime = new boolean[1000001];
        
        Arrays.fill(isPrime, true);
        for(int i = 2; i < Math.sqrt(isPrime.length); i++){
            if(isPrime[i]){
                for(int j = i * i; j < isPrime.length; j += i){
                    isPrime[j] = false;
                }
            }
        }
        
        long answer = IntStream.rangeClosed(2, n).filter((v) -> (isPrime[v])).count();
        return (int)answer;
    }
}