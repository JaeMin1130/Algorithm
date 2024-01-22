import java.util.*;

class Solution {
    public int solution(int a, int b, int c, int d) {
        int answer = 1;
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : new int[] { a, b, c, d }) {
            map.computeIfPresent(num, (k, v) -> v + 1);
            map.putIfAbsent(num, 1);
        }
        
        int size = map.keySet().size();
        Iterator<Integer> iter = map.keySet().iterator();
        
        switch (size) {
            case 1:
                answer = iter.next() * 1111;
                break;
            case 4:
                int min = map.keySet().stream().sorted().findFirst().get();
                answer = min;
                break;
            case 3:
                while (iter.hasNext()) {
                    int key = iter.next();
                    if (map.get(key) == 1) {
                        answer *= key;
                    }
                }
                break;
            case 2:
                int p = iter.next();
                int q = iter.next();
                int num1 = map.get(p);
                int num2 = map.get(q);
                if (num1 == num2) {
                    answer = (p + q) * Math.abs(p - q);
                } else {
                    answer = num1 == 3 ? (int) Math.pow(10 * p + q, 2) : (int) Math.pow(10 * q + p, 2);
                }
                break;
        }
        
        return answer;
    }
}
