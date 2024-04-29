import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<Character, Integer> colorMap = new HashMap<>();
        Map<Integer, Integer> numberMap = new HashMap<>();

        for (int i = 0; i < 5; i++) {
            String[] input = br.readLine().split(" ");
            char color = input[0].charAt(0);
            int number = Integer.parseInt(input[1]);

            colorMap.computeIfPresent(color, (k, v) -> v + 1);
            colorMap.putIfAbsent(color, 1);

            numberMap.computeIfPresent(number, (k, v) -> v + 1);
            numberMap.putIfAbsent(number, 1);
        }

        boolean isSameColor = colorMap.size() == 1 ? true : false;
        boolean isContinuous = numberMap.size() == 5? true : false;
        int[] arr = numberMap.keySet().stream().mapToInt(Integer::valueOf).sorted().toArray();
        int temp = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (temp + 1 != arr[i]) {
                isContinuous = false;
                break;
            }
            temp = arr[i];
        }

        int score = 0;
        int maxNum = numberMap.keySet().stream().mapToInt(Integer::valueOf).max().getAsInt();
        // 카드 5장이 모두 같은 색이면서 숫자가 연속적일 때, 점수는 가장 높은 숫자에 900을 더한다.
        if (isSameColor && isContinuous) {
            score = 900 + maxNum;
        }
        // 5장의 카드 색깔이 모두 같을 때 점수는 가장 높은 숫자에 600을 더한다.
        else if (isSameColor && !isContinuous) {
            score = 600 + maxNum;
        }
        // 카드 5장의 숫자가 연속적일 때 점수는 가장 높은 숫자에 500을 더한다.
        else if (!isSameColor && isContinuous) {
            score = 500 + maxNum;
        }

        int maxCommonCount = numberMap.values().stream().mapToInt(Integer::valueOf).max().getAsInt();
        switch (maxCommonCount) {
            // 카드 5장 중 4장의 숫자가 같을 때 점수는 같은 숫자에 800을 더한다.
            case 4:
                for (int key : numberMap.keySet()) {
                    if (numberMap.get(key) != 4) continue;
                    score = Math.max(score, 800 + key);
                }
                break;

            case 3:
                // 카드 5장 중 3장의 숫자가 같고 나머지 2장도 숫자가 같을 때 
                // 점수는 3장이 같은 숫자에 10을 곱하고 2장이 같은 숫자를 더한 다음 700을 더한다.
                if (numberMap.size() == 2) {
                    int sum = 0;
                    for (int key : numberMap.keySet()) {
                        if (numberMap.get(key) == 3)
                            sum += key * 10;
                        if (numberMap.get(key) == 2)
                            sum += key;
                    }
                    score = Math.max(score, 700 + sum);
                }
                // 카드 5장 중 3장의 숫자가 같을 때 점수는 같은 숫자에 400을 더한다.
                else {
                    for (int key : numberMap.keySet()) {
                        if (numberMap.get(key) == 1) continue;
                        score = Math.max(score, 400 + key);
                    }
                }

                break;
            case 2:
                // 카드 5장 중 2장의 숫자가 같고 또 다른 2장의 숫자가 같을 때 
                // 점수는 같은 숫자 중 큰 숫자에 10을 곱하고 같은 숫자 중 작은 숫자를 더한 다음 300을 더한다.
                int[] nums = new int[2];
                int idx = 0;
                if (numberMap.size() == 3) {
                    for (int key : numberMap.keySet()) {
                        if (numberMap.get(key) == 2) {
                            nums[idx++] = key;
                        }
                    }
                    score = Math.max(score, 300 + Math.max(nums[0], nums[1]) * 10 + Math.min(nums[0], nums[1]));
                }
                // 카드 5장 중 2장의 숫자가 같을 때 점수는 같은 숫자에 200을 더한다.
                else {
                    for (int key : numberMap.keySet()) {
                        if (numberMap.get(key) == 1) continue;
                        score = Math.max(score, 200 + key);
                    }

                }

                break;
            // 위의 어떤 경우에도 해당하지 않을 때 점수는 가장 큰 숫자에 100을 더한다.
            default:
                score = Math.max(score, 100 + maxNum);
                break;
        }

        System.out.println(score);
    }
}