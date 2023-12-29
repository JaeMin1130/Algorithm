import java.util.*;

class Solution {
    public int solution(String numbers) {
        int answer = 0;
        
        boolean[] isPrime = new boolean[10000000];
        Arrays.fill(isPrime, true);
        isPrime[1] = false;
        isPrime[0] = false;
        
        for (int i = 2; i < Math.sqrt(10000000); i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < isPrime.length; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        Set<Integer> uniqueNumbers = new HashSet<>();
        generatePermutations("", numbers, new boolean[numbers.length()], uniqueNumbers);

        for (int num : uniqueNumbers) {
            System.out.println(num);
            if (isPrime[num]) {
                answer++;
            }
        }
        
        return answer;
    }

    private void generatePermutations(String current, String numbers, boolean[] visited, Set<Integer> uniqueNumbers) {
        if (!current.isEmpty()) {
            uniqueNumbers.add(Integer.parseInt(current));
        }

        for (int i = 0; i < numbers.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                generatePermutations(current + numbers.charAt(i), numbers, visited, uniqueNumbers);
                visited[i] = false;
            }
        }
    }
}
