import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        boolean[][] cheese = new boolean[N][M];
        int total = 0;

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                int c = Integer.parseInt(st.nextToken());
                if(c == 1) {
                    total++;
                    cheese[i][j] = true;
                }
            }
        }

        int time = 0;
        while(total > 0) {
            //BFS
            int[][] count = new int[N][M];

            boolean[][] visited = new boolean[N][M];
            Queue<int[]> q = new ArrayDeque<>();
            visited[0][0] = true;
            q.offer(new int[]{0, 0});

            while(!q.isEmpty()) {
                int[] cur = q.poll();

                for(int d = 0; d < 4; d++) {
                    int nr = cur[0] + dir[d][0];
                    int nc = cur[1] + dir[d][1];

                    if(0 <= nr && nr < N && 0 <= nc && nc < M && !visited[nr][nc]) {
                        if(cheese[nr][nc]) {
                            count[nr][nc]++;
                        } else {
                            visited[nr][nc] = true;
                            q.offer(new int[]{nr, nc});
                        }
                    }
                }
            }

            for(int i = 1; i < N - 1; i++) {
                for(int j = 1; j < M - 1; j++) {
                    if (count[i][j] > 1) {
                        cheese[i][j] = false;
                        total--;
                    }
                }
            }
            time++;
        }

        System.out.println(time);
        br.close();
    }
}
