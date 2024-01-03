class Solution {
    public String solution(int[] food) {
        StringBuilder answerBuilder = new StringBuilder();

        for (int i = 1; i < food.length; i++) {
            if (food[i] % 2 != 0) {
                food[i]--;
            }
            for (int j = 0; j < food[i] / 2; j++) {
                answerBuilder.append(i);
            }
        }

        String answer = answerBuilder.toString() + 0 + answerBuilder.reverse().toString();
        
        return answer;
    }
}
