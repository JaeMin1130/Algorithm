class Solution {
    public String solution(String s, int n) {
        
        StringBuilder result = new StringBuilder("");
        
        for (char c : s.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                c = (char) (c + n);
                if (c > 'Z') {
                    c -= 26;
                }
            }
            if (c >= 'a' && c <= 'z') {
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