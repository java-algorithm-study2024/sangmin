import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * System.out.println()은 여러 편의성을 제공하지만 속도가 매우 느리다.
 */
public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] narr = new int[n];
        int[] marr = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            narr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            marr[i] = Integer.parseInt(st.nextToken());
        }

        int nIndex = 0, mIndex = 0;
        int k = 0;
        int[] answer = new int[n+m];

        while (nIndex < n && mIndex < m) {
            if (narr[nIndex] >= marr[mIndex]) {
                answer[k] = marr[mIndex];
                k++;
                mIndex++;
            } else {
                answer[k] = narr[nIndex];
                k++;
                nIndex++;
            }
        }

        if(nIndex == n){
            for(int i = mIndex; i< m; i++){
                answer[k] = marr[mIndex];
                k++;
                mIndex++;
            }
        } else if(mIndex == m){
            for(int i = nIndex; i< n; i++){
                answer[k] = narr[nIndex];
                k++;
                nIndex++;
            }
        }
        
        for(int i=0; i< m+n; i++){
            bw.write(answer[i] + " ");
        }

        bw.flush();


    }
}
