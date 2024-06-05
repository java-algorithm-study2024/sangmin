import java.util.*;
import java.io.*;

/**
 *
 */
public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] s = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Queue<Patient> q = new LinkedList<>();

        int danger = s[m];
        int maxDanger = 0;

        for (int i = 0; i < n; i++) {

            if (maxDanger < s[i]) {
                maxDanger = s[i];
            }
            Patient patient = new Patient(i, s[i]);
            q.offer(patient);
        }

        int answer = 1;
        while (true) {

            if (q.isEmpty()) {
                return;
            }

            Patient patient = q.peek();

            if (patient.danger < maxDanger) {
                q.offer(q.poll());
            } else {
                int index = patient.index;
                if (index == m) {
                    break;
                } else {
                    q.poll();
                    answer++;
                }

                maxDanger = 0;

                for (int i = 0; i < q.size(); i++) {

                    Patient patient2 = q.poll();

                    if (maxDanger < patient2.danger) {
                        maxDanger = patient2.danger;
                    }

                    q.offer(patient2);
                }
            }

        }

        bw.write(String.valueOf(answer));
        bw.flush();

    }

    private static class Patient implements Comparable<Patient> {
        private final int index;
        private final int danger;

        public Patient(int index, int danger) {
            this.index = index;
            this.danger = danger;
        }

        @Override
        public int compareTo(Patient patient) {
            return Integer.compare(patient.danger, this.danger);
        }
    }


}
