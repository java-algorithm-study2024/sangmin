import java.util.*;
import java.io.*;

/**
 * 스택 원소가 없을 때 pop(), peek() 함수 호출 시, EmptyStackException 발생한다.
 */
public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        ArrayList<Character> ch = new ArrayList<>();
        boolean answer = true;
        Stack<Integer> stack = new Stack<>();
        int index = 1;

        for (int i = 0; i < n; i++) {

            if (index <= arr[i]) {
                while (index <= arr[i]) {
                    ch.add('+');
                    stack.push(index++);
                }
            }

            if (stack.peek() > arr[i]) {
                answer = false;
                break;
            }

            if (stack.peek() == arr[i]) {
                ch.add('-');
                stack.pop();
                continue;
            }

        }

        if(answer == true){
         ch.forEach(System.out::println);
        } else {
            System.out.println("NO");
        }
    }
}
