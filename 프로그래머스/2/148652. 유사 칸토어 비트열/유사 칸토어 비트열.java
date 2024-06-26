class Solution {
    public int solution(int n, long l, long r) {
        int answer = 0;
        int[] cantor = {1, 1, 0, 1, 1};
        long start = l - 1;
        long end = r - 1;
        for(long i = start; i <= end; i++){
            long num = i;
            if(n == 1) answer += cantor[(int)num];
            
            for(int j = n - 1; j > 0; j--){
                long div = (long)Math.pow(5, j);
                if(num / div == 2) break;
                num %= div;
                
                if(j == 1 && cantor[(int)num] == 1) answer++;
            }
        }
        return answer;
    }
}