class Solution {
    public int solution(String s) {
        int answer = 0;
        char[] arr = s.toCharArray();
        int len = s.length() - 2;
        
        for(int i = 1; i < arr.length; i++){
            int num = arr[i] - '0';
            answer += num * Math.pow(10, len--);
        }
        
        if(arr[0] == '-'){
            answer *= -1;
        }else if(arr[0] != '+'){
            int num = arr[0] - '0';
            answer += num * Math.pow(10, s.length() - 1);
        }
        
        return answer;
    }
}