import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        PriorityQueue<Long> pq = new PriorityQueue<>();
        for(int i = 0; i < N; i++) {
            pq.offer(Long.parseLong(st.nextToken()));
        }

        for(int i = 0; i < M; i++) {
            long a = pq.poll();
            long b = pq.poll();

            pq.offer(a + b);
            pq.offer(a + b);
        }

        long sum = 0;
        while(!pq.isEmpty()) {
            sum += pq.poll();
        }

        System.out.println(sum);
        br.close();
    }
}
