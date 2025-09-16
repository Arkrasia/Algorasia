import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][][] tomato;
    static int N, M, H;
    static int[][] dir = {{0, -1, 0}, {0, 0, 1}, {0, 1, 0}, {0, 0, -1}, {-1, 0, 0}, {1, 0, 0}};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        tomato = new int[H][M][N];

        int cnt = 0;
        Queue<int[]> q = new ArrayDeque<>();
        for(int h = 0; h < H; h++) {
            for(int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++) {
                    tomato[h][i][j] = Integer.parseInt(st.nextToken());
                    if(tomato[h][i][j] == 0) cnt++;
                    else if(tomato[h][i][j] == 1) {
                        q.offer(new int[] {h, i, j});
                    }
                }
            }
        }

        int day = 0;
        while(!q.isEmpty()) {
            if(cnt == 0) break;
            
            int size = q.size();
            for(int i = 0; i < size; i++) {
                int[] cur = q.poll();

                for (int d = 0; d < 6; d++) {
                    int nh = cur[0] + dir[d][0];
                    int ni = cur[1] + dir[d][1];
                    int nj = cur[2] + dir[d][2];

                    if (inRange(nh, ni, nj)) {
                        tomato[nh][ni][nj] = 1;
                        q.offer(new int[]{nh, ni, nj});
                        cnt--;
                    }
                }
            }
            day++;
        }

        if(cnt == 0) System.out.println(day);
        else System.out.println(-1);

        br.close();
    }

    public static boolean inRange(int h, int i, int j) {
        return 0 <= h && h < H && 0 <= i && i < M && 0 <= j && j < N && tomato[h][i][j] == 0;
    }
}
