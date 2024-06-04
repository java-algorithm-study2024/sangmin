import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> bucket = new Stack<>();
        
        for(int move : moves){
            for(int i=0; i< board.length; i++){

                if(board[i][move-1] == 0) {
                    continue;
                } else {
                    if(!bucket.isEmpty() && (bucket.peek() == board[i][move-1])){
                        bucket.pop();
                        answer+=2;
                    } else {
                        bucket.push(board[i][move-1]);
                    }
                    board[i][move-1] = 0;
                    break;
                }
            }
        }
        return answer;
    }
}
