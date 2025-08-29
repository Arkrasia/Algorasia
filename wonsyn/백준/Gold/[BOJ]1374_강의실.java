import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][2];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            st.nextToken();
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            arr[i][0] = start; arr[i][1] = end;
        }
        Arrays.sort(arr, (o1, o2) -> o1[0] - o2[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int idx = 1;
        int cnt = 1;
        int time = arr[0][0];
        pq.offer(arr[0][1]);
        while(idx < N) {
            if(pq.isEmpty() || pq.peek() > arr[idx][0]) time = arr[idx][0];
            else time = pq.peek();

            while(!pq.isEmpty() && pq.peek() == time) {
                pq.poll();
            }

            while(idx < N && arr[idx][0] == time) {
                pq.offer(arr[idx++][1]);
            }

            cnt = Math.max(cnt, pq.size());
        }

        System.out.println(cnt);
        br.close();
    }
}
