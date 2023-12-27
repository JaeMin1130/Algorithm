class Solution {
    public int[] solution(String s) {
        
        int binaryCount = 0;
        int zeroCount = 0;
        
        while(!s.equals("1")){
            for(String num : s.split("")){
                if(num.equals("0")){
                    s = s.replace("0", "");
                    zeroCount++;
                }
            }
            
            int len = s.length();
            s = "";
            while(len != 0){
                s += String.valueOf(len % 2);
                len /= 2;
            }
            
            binaryCount++;
        }
        return new int[]{binaryCount, zeroCount};
    }
}