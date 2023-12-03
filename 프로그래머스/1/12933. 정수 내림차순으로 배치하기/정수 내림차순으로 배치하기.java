import java.util.*;

class Solution {
    public long solution(long n) {
        ArrayList<Long> nums = new ArrayList<>();

        while(n > 0){
            nums.add(n % 10);
            n /= 10;
        }

        nums.sort((n1, n2) -> {return (int) (n2 - n1);});
        StringBuilder number = new StringBuilder();

        for(int i = 0; i < nums.size(); i++){
            number.append(String.valueOf(nums.get(i)));
        }

        return Long.parseLong(number.toString());
    }
}