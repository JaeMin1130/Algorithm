class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        double val1 = brown + yellow;
        double val2 = val1 / 2 + 2 - yellow / 2;
        
        for(int height = 3; height <= 2_000_000; height++){
            if(val1 % height != 0) continue;
            int width = (int)val1 / height;
            
            if(height + width == (int)val2){
                answer[0] = width;
                answer[1] = height;
                break;
            }
        }
        
        return answer;
    }
}