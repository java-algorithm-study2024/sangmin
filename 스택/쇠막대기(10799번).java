import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        Stack<Character> bar = new Stack<>();
        int answer = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                bar.push('(');
            } else if (ch == ')' && bar.peek() == '(') {
                bar.pop();
                bar.push('*');
            } else if (ch == ')' && bar.peek() != '(') {

                int index = bar.search('(');

                // 몇 등분 되었는지 표시,,
                answer = answer + (index - 1) + 1;


                bar.remove(bar.size() - index );

            }
        }

        System.out.println(answer);

    }
}
