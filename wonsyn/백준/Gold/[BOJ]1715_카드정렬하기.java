import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(list);

        int cnt = 0;
        while(pq.size() > 1) {
            int a = pq.poll();
            int b = pq.poll();
            cnt += a + b;
            pq.offer(a + b);
        }

        System.out.println(cnt);
        br.close();
    }
}
