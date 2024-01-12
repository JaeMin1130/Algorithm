import java.util.*;

class Solution {
    public int solution(String s) {
        
        Map<String, String> map = new HashMap<>();
        String[] nums = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], String.valueOf(i));
        }
        
        for(String key : map.keySet()){
            s = s.replaceAll(key, map.get(key));
        }

        return Integer.parseInt(s);
    }
}