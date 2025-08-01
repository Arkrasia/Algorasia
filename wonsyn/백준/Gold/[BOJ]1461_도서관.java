import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> pq1 = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> pq2 = new PriorityQueue<>();

        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()) {
            int n = Integer.parseInt(st.nextToken());
            if(n < 0) pq2.offer(n);
            else pq1.offer(n);
        }

        int move = 0;

        PriorityQueue<Integer> selected;
        if(pq1.isEmpty()) selected = pq2;
        else if(pq2.isEmpty()) selected = pq1;
        else {
            int n1 = pq1.peek(), n2 = pq2.peek();
            if(Math.abs(n1) < Math.abs(n2)) selected = pq2;
            else selected = pq1;
        }
        move += Math.abs(selected.poll());
        int cnt = 1;
        while(!selected.isEmpty() && cnt < M) {
            selected.poll(); cnt++;
        }

        while(!pq1.isEmpty()) {
            move += pq1.poll() * 2;
            cnt = 1;
            while(!pq1.isEmpty() && cnt < M) {
                pq1.poll(); cnt++;
            }
        }

        while(!pq2.isEmpty()) {
            move -= pq2.poll() * 2;
            cnt = 1;
            while(!pq2.isEmpty() && cnt < M) {
                pq2.poll(); cnt++;
            }
        }

        System.out.println(move);

        br.close();
    }
}
