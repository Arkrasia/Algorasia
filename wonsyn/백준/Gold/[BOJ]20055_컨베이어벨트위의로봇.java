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
        int K = Integer.parseInt(st.nextToken());

        int[] A = new int[2 * N];
        boolean[] check = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < A.length; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        Queue<Integer> q = new ArrayDeque<>();
        int time = 0;
        int cnt = 0;
        while(cnt < K) {
            time++;
            int size = q.size();

            // 벨트 회전
            for(int i = 0; i < size; i++) {
                int cur = q.poll() + 1;
                if(cur < N) q.offer(cur);
            }
            int temp = A[A.length - 1];
            for(int i = A.length - 1; i > 0; i--) A[i] = A[i - 1];
            A[0] = temp;
            for(int i = check.length - 1; i > 0; i--) check[i] = check[i - 1];
            check[0] = false;

            // 로봇 이동
            size = q.size();
            for(int i = 0; i < size; i++) {
                int cur = q.poll();
                int next = cur + 1;

                if(next == N) {
                    check[cur] = false;
                    continue;
                }

                if(A[next] != 0 && !check[next]) {
                    check[cur] = false;
                    A[next]--; check[next] = true;
                    if(A[next] == 0) cnt++;
                    cur = next;
                }
                q.offer(cur);
            }

            // 로봇 올리기
            if(A[0] != 0 && !check[0]) {
                q.offer(0);
                check[0] = true; A[0]--;
                if(A[0] == 0) cnt++;
            }
        }

        System.out.println(time);
        br.close();
    }
}
