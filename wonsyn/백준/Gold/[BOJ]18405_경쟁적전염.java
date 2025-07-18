import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, K, S, X, Y;
    static int[][] tube, dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static Queue<int[]>[] virus;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        tube = new int[N][N];
        virus = new ArrayDeque[K + 1];

        for(int i = 1; i <= K; i++) {
            virus[i] = new ArrayDeque<>();
        }

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                tube[i][j] = Integer.parseInt(st.nextToken());

                if(tube[i][j] != 0) virus[tube[i][j]].offer(new int[]{i, j});
            }
        }

        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        int[] size = new int[K + 1];
        for(int s = 0; s < S; s++) {
            for(int i = 1; i <= K; i++) {
                size[i] = virus[i].size();
            }

            for(int i = 1; i <= K; i++) {
                for(int j = 0; j < size[i]; j++) {
                    int[] cur = virus[i].poll();

                    for(int d = 0; d < 4; d++) {
                        int nr = cur[0] + dir[d][0];
                        int nc = cur[1] + dir[d][1];

                        if(0 <= nr && nr < N && 0 <= nc && nc < N && tube[nr][nc] == 0) {
                            tube[nr][nc] = i;
                            virus[i].offer(new int[] {nr, nc});
                        }
                    }
                }
            }
        }

        System.out.println(tube[X - 1][Y - 1]);
        br.close();
    }
}
