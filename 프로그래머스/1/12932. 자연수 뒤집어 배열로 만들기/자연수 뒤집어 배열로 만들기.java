class Solution {
    public int[] solution(long n) {

        String num = String.valueOf(n);
        char[] arr = num.toCharArray();
        int[] answer = new int[arr.length];
        
        for(int i = 0, j = arr.length - 1; i < answer.length; i++, j--){
            answer[i] = arr[j] - '0';
        }
        return answer;
    }
}