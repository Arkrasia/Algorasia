import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] lab;
    static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static int N, M;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int max = N * M;

        lab = new int[N][M];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                lab[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = Integer.MIN_VALUE;
        for(int i = 0; i < max - 2; i++) {
            if(lab[i / M][i % M] == 0) {
                lab[i / M][i % M] = 1;
                for(int j = i + 1; j < max - 1; j++) {
                    if(lab[j / M][j % M] == 0) {
                        lab[j / M][j % M] = 1;
                        for(int k = j + 1; k < max; k++) {
                            if(lab[k / M][k % M] == 0) {
                                lab[k / M][k % M] = 1;
                                ans = Math.max(ans, check());
                                lab[k / M][k % M] = 0;
                            }
                        }
                        lab[j / M][j % M] = 0;
                    }
                }
                lab[i / M][i % M] = 0;
            }
        }

        System.out.println(ans);
        br.close();
    }

    public static int check() {
        Queue<int[]> q = new ArrayDeque<>();

        int[][] copy = new int[N][];
        for(int i = 0; i < N; i++) {
            copy[i] = lab[i].clone();
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(copy[i][j] == 2) q.offer(new int[]{i, j});
            }
        }

        while(!q.isEmpty()) {
            int[] cur = q.poll();

            for(int d = 0; d < 4; d++) {
                int dx = cur[0] + dir[d][0];
                int dy = cur[1] + dir[d][1];
                if(0 <= dx && dx < N && 0 <= dy && dy < M && copy[dx][dy] == 0) {
                    copy[dx][dy] = 2;
                    q.offer(new int[]{dx, dy});
                }
            }
        }

        int cnt = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(copy[i][j] == 0) cnt++;
            }
        }
        return cnt;
    }
}
