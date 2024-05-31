import java.util.*;


/**
 *
 */
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] arr = new String[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.next();
        }

        Stack<Character> stack = new Stack<>();
        boolean answer = true;
        // 입력 데이터 n개의 대해 진행한다.
        for (int i = 0; i < n; i++) {
            int left = 0, right = 0;
            char[] c = arr[i].toCharArray();

            for (int j = 0; j < c.length; j++) {
                // 만약 ( 기호면 스택에 push
                if (c[j] == '(') {
                    stack.push(c[j]);
                    // 만약 ) 기호면 스택에 pop인데 stack이 비었을 경우, VPS가 아니다.
                } else {
                    if(stack.isEmpty()){
                        answer = false;
                        break;
                    }
                    stack.pop();
                }
            }

            if (answer == true && stack.isEmpty()) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
            // 변수 초기화
            stack.clear();
            answer=true;
        }
    }
}
