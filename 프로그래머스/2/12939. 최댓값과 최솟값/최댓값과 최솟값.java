import java.util.*;

class Solution {
    public String solution(String s) {
        
        String answer = "";
        
        String[] nums = s.split(" ");
        
        Arrays.sort(nums, (s1, s2) -> Integer.compare(Integer.parseInt(s1), Integer.parseInt(s2)));
        
        answer = String.valueOf(nums[0]) + " " + String.valueOf(nums[nums.length - 1]);
        
        return answer;
    }
}