class Solution {
    public String solution(int a, int b) {
        String[] days = {"THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED"};
        int[] months = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        int totalDay = 0;
        for(int i = 1; i < a; i++){
            totalDay += months[i];
        }
        
        totalDay = (totalDay + b) % 7;
        
        String answer = days[totalDay];
        
        return answer;
    }
}