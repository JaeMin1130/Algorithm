import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {

    public static boolean solution(String[] phone_book) {
        Map<String, Boolean> map = new HashMap<>();
        boolean answer = true;

        Arrays.sort(phone_book, (i, j) -> {
            Integer a = String.valueOf(i).length();
            Integer b = String.valueOf(j).length();
            return a.compareTo(b) * -1;
        });

        for (String string : phone_book) {
            map.put(string, true);
        }
        
        for (String string : phone_book) {
            for (int i = 1; i < string.length(); i++) {
                if (map.keySet().contains(string.substring(0, i))) {
                    answer = false;
                    break;
                }
                if (!answer)
                    break;
            }
        }
        return answer;
    }
}