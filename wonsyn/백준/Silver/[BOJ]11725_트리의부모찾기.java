import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<Integer>[] lists = new List[N + 1];

        for(int i = 1; i <= N; i++) {
            lists[i] = new ArrayList<>();
        }
        int[] ans = new int[N + 1];

        for(int i = 1; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            lists[a].add(b);
            lists[b].add(a);
        }

        Queue<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[N + 1];
        q.offer(1);
        visited[1] = true;
        while(!q.isEmpty()) {
            int cur = q.poll();

            for(Integer i : lists[cur]) {
                if(!visited[i]) {
                    visited[i] = true;
                    ans[i] = cur;
                    q.offer(i);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 2; i <= N; i++) {
            sb.append(ans[i]).append("\n");
        }
        System.out.print(sb);
        br.close();
    }
}
