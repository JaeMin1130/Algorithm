class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder("");
        int count = 0;
        for (int j = 0; j < s.length(); j++) {
            if (s.charAt(j) == ' ') {
                answer.append(' ');
                count = 0;
                continue;
            }
            String letter = s.substring(j, j + 1);
            if (count++ % 2 == 0) {
                letter = letter.toUpperCase();
            } else {
                letter = letter.toLowerCase();
            }
            answer.append(letter);
        }
        return answer.toString();
    }
}