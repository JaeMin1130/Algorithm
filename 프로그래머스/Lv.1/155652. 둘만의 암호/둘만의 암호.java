class Solution {
    public String solution(String s, String skip, int index) {
        boolean[] isSkipped = new boolean[26];
        for (char c : skip.toCharArray()) {
            isSkipped[c - 'a'] = true;
        }

        StringBuilder result = new StringBuilder("");
        for (char c : s.toCharArray()) {
            int count = 0;
            while (count < index) {
                c++;
                if (c > 'z') {
                    c -= 26;
                }
                if (!isSkipped[c - 'a']) {
                    count++;
                }
                if (c > 'z') {
                    c -= 26;
                }
            }

            result.append((char) c);
        }

        return result.toString();
    }
}