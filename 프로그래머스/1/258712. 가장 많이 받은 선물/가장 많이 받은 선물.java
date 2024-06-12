import java.util.*;
import java.util.stream.IntStream;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        Map<String, Integer> friendIdxMap = new HashMap<>();
        for(int i = 0; i < friends.length; i++){
            friendIdxMap.put(friends[i], i);
        }
        
        int[][] board = new int[friends.length][friends.length];
        for(String gift : gifts){
            String[] arr = gift.split(" ");
            int giver = friendIdxMap.get(arr[0]);
            int taker = friendIdxMap.get(arr[1]);
            board[giver][taker]++;
        }
        
        int[] presentScore = new int[friends.length];
        for(int i = 0; i < friends.length; i++){
            int giveCount = 0;
            int takeCount = 0;
            for(int j = 0; j < friends.length; j++){
                giveCount += board[i][j];
                takeCount += board[j][i];
            }
            presentScore[i] = giveCount - takeCount;
        }
        
        
        int[] nextMonth = new int[friends.length];
        for(int i = 0; i < friends.length - 1; i++){
            for(int j = i + 1; j < friends.length; j++){
                if(board[i][j] == board[j][i]){
                    if(presentScore[i] == presentScore[j]) continue;
                    nextMonth[presentScore[i] > presentScore[j] ? i : j]++; 
                    continue;
                }
                
                nextMonth[board[i][j] > board[j][i] ? i : j]++;
            }
        }
        
        OptionalInt answer = IntStream.of(nextMonth).max();
        return answer.getAsInt();
    }
}