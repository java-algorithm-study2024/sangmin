import java.util.*;
import java.io.*;

public class Solution {
    public int[] solution(int []arr) {
        
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> array = new ArrayList();
        
        for(int element : arr) {
            
            if(stack.isEmpty()){
                stack.push(element);
                array.add(element);
            } else if(!stack.isEmpty() && stack.peek() != element){
                stack.push(element);
                array.add(element);
            }
        }
        
        int[] answer = new int[array.size()];
        for(int i=0; i<answer.length; i++){
            answer[i] = array.get(i);
        }

                return answer;
    }
            
}
