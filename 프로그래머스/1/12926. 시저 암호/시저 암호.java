class Solution {
    public String solution(String s, int n) {
        
        StringBuilder result = new StringBuilder("");
        
        for (char c : s.toCharArray()) {
            if (Character.isUpperCase(c)) {
                c = (char) (c + n);
                if (c > 'Z') {
                    c -= 26;
                }
            }
            if (Character.isLowerCase(c)) {
                c = (char) (c + n);
                if (c > 'z') {
                    c -= 26;
                }
            }

            result.append(c != ' ' ? c : " ");
        }
        
        return result.toString();
    }
}