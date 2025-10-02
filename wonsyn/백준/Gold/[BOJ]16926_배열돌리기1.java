import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}}; // 하 우 상 좌

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];
        int[][] res = new int[N][M];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int n = N, m = M, rr = R;
        int x = 0, y = 0;
        while(N > 0 && M > 0) {
            R = rr;
            int h = x + N, w = y + M;
            int len = 2 * (N - 1) + 2 * (M - 1);
            R %= len;

            int nx = x, ny = y;
            for(int l = 0; l < len; l++) {
                int ld;
                if(l < N) ld = 0;
                else if (l < N + M - 1) ld = 1;
                else if (l < 2 * (N - 1) + M) ld = 2;
                else ld = 3;

                int tx = nx, ty = ny, td = ld;
                for(int r = 0; r < R; r++) {
                    tx += dir[td][0]; ty += dir[td][1];
                    if(h <= tx || tx < x || w <= ty || ty < y) {
                        tx -= dir[td][0]; ty -= dir[td][1];
                        td = (td + 1) % 4;
                        tx += dir[td][0]; ty += dir[td][1];
                    }
                }

                res[tx][ty] = arr[nx][ny];

                nx += dir[ld][0]; ny += dir[ld][1];
                if(h <= nx || nx < x || w <= ny || ny < y) {
                    nx -= dir[ld][0]; ny -= dir[ld][1];
                    ld = (ld + 1) % 4;
                    nx += dir[ld][0]; ny += dir[ld][1];
                }
            }

            N -= 2; M -= 2;
            x++; y++;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                sb.append(res[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}
