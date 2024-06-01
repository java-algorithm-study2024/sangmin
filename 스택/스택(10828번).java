import java.util.*;
import java.io.*;

/**
 * StringTokenizer(문자열,구분자) >> 구분자가 없으면 디폴트 스페이스,tab,개행문자를 구분자로 사용한다. 구분자 자체는 token으로 인식되지 않는다.
 * 
 * ArrayList vs LinkedList 차이점 ArrayList는 배열처럼 사용되지만 처음에 크기를 지정해주지 않아도 된다. index로 바로 접근이 가능하여 O(1) 시간 복잡도를 가진다. >> 무작위
 * 접근 가능 중간 위치의 데이터를 삭제하면 뒤에 데이터 전부를 하나씩 옮겨야 하는 비효율성이 존재한다. LinkedList는 양방향 연결 리스트로 구성되어 있다. >> 순차 접근만 가능 데이터 추가.삭제 시
 * 가리키고 있는 주소 값만 변경하면 되어 ArrayList보다 삭제.삽입 연산에 더 효율적이다.
 */
public class Main {

    private static void push(ArrayList<Integer> array, int value) {
        array.add(value);
    }

    private static Integer pop(ArrayList<Integer> array) {
        if (array.isEmpty()) {
            return -1;
        } else {
            int value = array.get(array.size() - 1);
            array.remove(array.size() - 1);
            return value;
        }
    }

    private static Integer size(ArrayList<Integer> array) {
        return array.size();
    }

    private static Integer empty(ArrayList<Integer> array) {
        if (array.isEmpty()) {
            return 1;
        } else {
            return 0;
        }
    }

    private static Integer top(ArrayList<Integer> array) {
        if (array.isEmpty()) {
            return -1;
        }
        return array.get(array.size() - 1);
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] data = new String[n];

        for (int i = 0; i < n; i++) {
            data[i] = br.readLine();
        }

        ArrayList<Integer> array = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(data[i]);
            String operator = st.nextToken();

            switch (operator) {
                case "push":
                    int value = Integer.parseInt(st.nextToken());
                    push(array, value);
                    continue;
                case "pop":
                    System.out.println(pop(array));
                    continue;
                case "size":
                    System.out.println(size(array));
                    continue;
                case "empty":
                    System.out.println(empty(array));
                    continue;
                case "top":
                    System.out.println(top(array));
                    continue;
            }
        }
    }
}
