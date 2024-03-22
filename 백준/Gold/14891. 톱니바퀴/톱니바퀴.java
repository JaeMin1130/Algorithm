import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class Main {
    static int[][] gears = new int[4][8];
    static List<Deque<Integer>> gearList = new ArrayList<>();
    static boolean[] isOpposite = new boolean[3];

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 4; i++) {
            String[] input = br.readLine().split("");
            Deque<Integer> dq = new LinkedList<>();
            Stream.of(input).mapToInt(Integer::parseInt).forEach((n) -> dq.add(n));
            gearList.add(dq);
            gears[i] = Stream.of(input).mapToInt(Integer::parseInt).toArray();
        }

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer input = new StringTokenizer(br.readLine());
            int gearNum = Integer.parseInt(input.nextToken());
            int dir = Integer.parseInt(input.nextToken());

            checkOpposite();
            rotate(gearNum, dir);
        }

        System.out.println(calScore());
    }

    static void checkOpposite() {
        isOpposite = new boolean[3];
        for (int i = 0; i < isOpposite.length; i++) {
            if (gears[i][2] != gears[i + 1][6]) {
                isOpposite[i] = true;
            }
        }
    }

    static void rotate(int gearNum, int dir) {
        int nextDir = dir;
        switch (gearNum) {
            case 1:
                updateNum(gearNum, dir);

                if(isOpposite[0]){
                    for (int i = 0; i < isOpposite.length; i++) {
                        if (!isOpposite[i]) break;
                        nextDir *= -1;
                        updateNum(i + 2, nextDir);
                    }
                }

                break;
            case 2:
                updateNum(gearNum, dir);

                if (isOpposite[0]) {
                    updateNum(1, dir * -1);
                }
                if (isOpposite[1]) {
                    updateNum(3, dir * -1);
                    if (isOpposite[2]) {
                        updateNum(4, dir);
                    }
                }

                break;
            case 3:
                updateNum(gearNum, dir);

                if (isOpposite[2]) {
                    updateNum(4, dir * -1);
                }
                if (isOpposite[1]) {
                        updateNum(2, dir * -1);
                        if(isOpposite[0]){
                            nextDir *= -1;
                            updateNum(1, dir);
                        }
                    }

                break;
            case 4:
                updateNum(gearNum, dir);
                
                if(isOpposite[2]){
                    for (int i = isOpposite.length - 1; i >= 0; i--) {
                        if (!isOpposite[i]) break;
                        nextDir *= -1;
                        updateNum(i + 1, nextDir);
                    }
                }
                

                break;
        }
    }


    static void updateNum(int gearNum, int dir) {
        Deque<Integer> gear = gearList.get(gearNum - 1);
        int temp = 0;
        if (dir == 1) {
            temp = gear.pollLast();
            gear.addFirst(temp);
        } else {
            temp = gear.pollFirst();
            gear.addLast(temp);
        }
        gears[gearNum - 1] = gear.stream().mapToInt(Integer::intValue).toArray();
    }

    static int calScore() {
        int result = 0;

        for (int i = 0; i < gears.length; i++) {
            if (gears[i][0] == 1) {
                result += Math.pow(2, i);
            }
        }

        return (result);
    }
}