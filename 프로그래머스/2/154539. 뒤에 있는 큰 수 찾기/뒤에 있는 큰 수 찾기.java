import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Arrays.fill(answer, -1);
        
        Stack<Integer> stack = new Stack<>();
        for(int i = numbers.length - 1; i >= 0; i--){
            int num = numbers[i];
            
            while(!stack.isEmpty() && num >= stack.peek()){
                stack.pop();
            }
            
            if(!stack.isEmpty()){
                answer[i] = stack.peek();
            }
            
            stack.add(num);
        }
        
        return answer;
    }
}