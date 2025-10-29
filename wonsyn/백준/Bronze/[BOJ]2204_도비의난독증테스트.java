import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        PriorityQueue<String> pq = new PriorityQueue<>((o1, o2) -> o1.toLowerCase().compareTo(o2.toLowerCase()));
        int N;
        while(true) {
            N = Integer.parseInt(br.readLine());
            if(N == 0) break;

            pq.clear();
            for(int i = 0; i < N; i++) {
                pq.offer(br.readLine());
            }
            sb.append(pq.poll()).append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}
