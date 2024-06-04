import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 *
 */
public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Integer> arr1 = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> arr2 = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt)
                .collect(Collectors.toList());

        arr1.addAll(arr2);
        Collections.sort(arr1);

        for(int element : arr1){
            System.out.print(element+" ");
        }

    }
}
