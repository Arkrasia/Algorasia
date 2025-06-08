import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb;
    static boolean[][] matrix;
    static boolean[] visited;
    static int N, M, V;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        matrix = new boolean[N + 1][N + 1];

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            matrix[start][end] = matrix[end][start] = true;
        }

        visited = new boolean[N + 1];
        dfs(V);
        sb.append("\n");
        visited = new boolean[N + 1];
        bfs(V);

        System.out.println(sb);
        br.close();
    }

    public static void dfs(int start) {
        sb.append(start).append(" ");
        visited[start] = true;

        for(int i = 0; i <= N; i++) {
            if(!visited[i] && matrix[start][i]) {
                dfs(i);
            }
        }
    }

    public static void bfs(int start) {
        Queue<Integer> q = new ArrayDeque<>();
        visited[start] = true;
        sb.append(start).append(" ");
        q.offer(start);

        while(!q.isEmpty()) {
            int cur = q.poll();

            for(int i = 0; i <= N; i++) {
                if(!visited[i] && matrix[cur][i]) {
                    visited[i] = true;
                    sb.append(i).append(" ");
                    q.offer(i);
                }
            }
        }
    }
}
