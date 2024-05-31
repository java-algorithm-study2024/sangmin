import java.io.*;
import java.util.*;


/**
 * 후위 표현식 개념 공부
 */
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        String s = br.readLine();
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Stack<Double> stack = new Stack<>();
        for(int i =0; i<s.length(); i++){
            char c = s.charAt(i);
            // A ~ Z 문자이면, 스택에 해당 값 넣는다.
            if('A'<=c && c<='Z'){
                int index = c - 'A';
                stack.push((double)arr[index]);
                // 연산자이면 스택에서 2개 꺼내 연산한다.
            } else {
                double a = stack.pop();
                double b = stack.pop();
                double result = 0;
                switch (c){
                    case '+':
                        result = b + a;
                        break;
                    case '-':
                        result = b - a;
                        break;
                    case '*':
                        result = b * a;
                        break;
                    case '/':
                        result = b / a;
                        break;
                }
                stack.push(result);
            }
        }

        System.out.println(String.format("%.2f",stack.pop()));
    }
}
