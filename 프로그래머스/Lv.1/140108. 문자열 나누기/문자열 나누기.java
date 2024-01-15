class Solution {
    static int answer = 1;

    public int solution(String s) {
        StringBuilder input = new StringBuilder(s);
        recur(input);
        return answer;
    }

    private void recur(StringBuilder input) {
        int same = 1;
        int different = 0;
        char target = input.charAt(0);
        for (int i = 1; i < input.length(); i++) {
            if (same == different) {
                input.delete(0, i);
                answer++;
                recur(input);
                break;
            } else {
                if (target == input.charAt(i)) {
                    same++;
                } else {
                    different++;
                }
            }
        }
    }
}