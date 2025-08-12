import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        Queue<int[]> on = new ArrayDeque<>();
        int[] wait = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            wait[i] = Integer.parseInt(st.nextToken());
        }

        int w = wait[0];
        int time = 1;
        int idx = 1;
        on.offer(new int[] {wait[0], time + W});
        while(!on.isEmpty()) {
            time++;
            int[] temp = on.peek();
            if(temp[1] == time) {
                on.poll();
                w -= temp[0];
            }

            if(idx < N && wait[idx] + w <= L) {
                int cur = wait[idx++];
                w += cur;
                on.offer(new int[]{cur, time + W});
            }
        }

        System.out.println(time);
        br.close();
    }
}
