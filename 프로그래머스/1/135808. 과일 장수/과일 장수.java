import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    public int solution(int k, int m, int[] score) {
        PriorityQueue<Integer> q = new PriorityQueue<>((v1, v2) -> v2 - v1);
        for(int n : score){
            q.add(n);
        }

        int answer = 0;
        List<Integer> box = new ArrayList<>();
        while(!q.isEmpty()){
            int value = q.poll();
            box.add(value);
            if(box.size() == m){
                answer += value * m;
                box.clear();
            }
        }

        return answer;
    }
}