import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        int[] arrX = new int[10];
        int[] arrY = new int[10];
        
        for(char c : X.toCharArray()){
            arrX[c - '0']++;
        }
        
        for(char c : Y.toCharArray()){
            arrY[c - '0']++;
        }
        
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            if(arrX[i] != 0 && arrY[i] != 0){
                int value = Math.min(arrX[i], arrY[i]);
                for(int j = 0; j < value; j++){
                    list.add(i);
                }
            }
        }
        
        if(list.size() == 0){
            return "-1";
        }else{
            list.sort((v1, v2) -> v2 - v1);
            StringBuilder result = new StringBuilder("");
            for(int num : list){
                result.append(num);
            }
            return result.charAt(0) == '0'? "0": result.toString();
        } 
    }
}