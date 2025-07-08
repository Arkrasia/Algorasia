import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, R;
    static int[][] arr;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}}; // 하 우 상 좌
    static int[] edge;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        edge = new int[4];
        edge[0] = N - 1; edge[2] = 0; edge[1] = M - 1;  edge[3] = 0;
        // 아래, 위, 오른쪽, 왼쪽

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while(edge[0] > edge[2] && edge[1] > edge[3]) {
            int x = edge[2], y = edge[3];

            int length = (edge[0] - edge[2]) * 2 + (edge[1] - edge[3]) * 2;
            Queue<Integer> q = new ArrayDeque<>();
            int d = 0;
            for(int l = 0; l < length; l++) {

                int nx = x + dir[d][0];
                int ny = y + dir[d][1];

                if(edge[2] > nx || edge[0] < nx || edge[3] > ny || edge[1] < ny) {
                    d = (d + 1) % 4;
                    l--;
                    continue;
                }

                q.offer(arr[x][y]);
                x = nx; y = ny;
            }

            int r = R % length;

            x = edge[2]; y = edge[3];
            d = 0;
            for(int i = 0; i < r; i++) {
                int nx = x + dir[d][0];
                int ny = y + dir[d][1];

                if(edge[2] > nx || edge[0] < nx || edge[3] > ny || edge[1] < ny) {
                    d = (d + 1) % 4;
                    i--;
                    continue;
                }
                x = nx; y = ny;
            }

            while(!q.isEmpty()) {
                int nx = x + dir[d][0];
                int ny = y + dir[d][1];

                if(edge[2] > nx || edge[0] < nx || edge[3] > ny || edge[1] < ny) {
                    d = (d + 1) % 4;
                    continue;
                }

                arr[x][y] = q.poll();
                x = nx; y = ny;
            }


            edge[0]--; edge[2]++; edge[1]--; edge[3]++;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);

        br.close();
    }
}
