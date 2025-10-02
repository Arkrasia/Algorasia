import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static boolean[][] matrix;
    static int[][] answer;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        matrix = new boolean[N][N];
        answer = new int[N][N];
        StringTokenizer st;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken()) == 1;
            }
        }

        for(int i = 0; i < N; i++) {
            Queue<Integer> q = new ArrayDeque<>();
            boolean[] visited = new boolean[N];
            q.offer(i);

            while(!q.isEmpty()) {
                int cur = q.poll();
                for(int j = 0; j < N; j++) {
                    if(!visited[j] && matrix[cur][j]) {
                        q.offer(j);
                        visited[j] = true;
                        answer[i][j] = 1;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                sb.append(answer[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}
