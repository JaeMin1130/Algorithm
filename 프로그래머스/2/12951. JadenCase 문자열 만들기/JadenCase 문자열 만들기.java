class Solution {
    public static String solution(String s) {
        String answer = "";
        String[] words = s.split("");
        
        boolean isFirstCharacter = true;
        
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(" ")) {
                answer += " ";
                isFirstCharacter = true;
            } else if (isFirstCharacter) {
                answer += words[i].toUpperCase();
                isFirstCharacter = false;
            } else {
                answer += words[i].toLowerCase();
            }
        }

        return answer;
    }
}