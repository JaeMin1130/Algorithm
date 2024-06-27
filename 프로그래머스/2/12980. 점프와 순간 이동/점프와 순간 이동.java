public class Solution {
    public int solution(int n) {
        int count = 0;
        
        while(n > 0){
            while(n % 2 == 0){
                n /= 2;
            }
            n--; count++;
        }
        
        return count;
    }
}