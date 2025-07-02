import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, max;
    static int[][] map, dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        max = -1;

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                visited[i][j] = true;
                dfs(i, j, 1, map[i][j]);
                check(i, j);
                visited[i][j] = false;
            }
        }

        System.out.println(max);
        br.close();
    }

    static void dfs(int r, int c, int cnt, int sum) {
        if(cnt == 4) {
            max = Math.max(max, sum);
            return;
        }

        for(int d = 0; d < 4; d++) {
            int nr = r + dir[d][0];
            int nc = c + dir[d][1];

            if(0 <= nr && nr < N && 0 <= nc && nc < M && !visited[nr][nc]) {
                visited[nr][nc] = true;
                dfs(nr, nc, cnt + 1, sum + map[nr][nc]);
                visited[nr][nc] = false;
            }
        }
    }

    static void check(int r, int c) {
        next:
        for(int d = 0; d < 4; d++) {
            int sum = map[r][c];
            for(int i = 1; i < 3; i++) {
                int nr = r + dir[d][0] * i;
                int nc = c + dir[d][1] * i;
                if(nr < 0 || N <= nr || nc < 0 || M <= nc) {
                    continue next;
                }
                sum += map[nr][nc];
            }

            int nd = (d + 1) % 4;
            int nr = r + dir[d][0] + dir[nd][0];
            int nc = c + dir[d][1] + dir[nd][1];
            if(nr < 0 || N <= nr || nc < 0 || M <= nc) continue;
            max = Math.max(max, sum + map[nr][nc]);

            nd = (d + 3) % 4;
            nr = r + dir[d][0] + dir[nd][0];
            nc = c + dir[d][1] + dir[nd][1];
            if(nr < 0 || N <= nr || nc < 0 || M <= nc) continue;
            max = Math.max(max, sum + map[nr][nc]);
        }
    }
}
