import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, L, R;
    static int[][] map, dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean flag = false;
        int day = 0;
        while(!flag) {
            flag = true;
            visited = new boolean[N][N];
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    if (!visited[r][c]) {
                        Queue<int[]> q = new ArrayDeque<>();
                        List<int[]> list = new ArrayList<>();

                        visited[r][c] = true;
                        int sum = map[r][c];
                        list.add(new int[]{r, c});
                        q.offer(new int[]{r, c});

                        while (!q.isEmpty()) {
                            int[] cur = q.poll();

                            for (int d = 0; d < 4; d++) {
                                int nr = cur[0] + dir[d][0];
                                int nc = cur[1] + dir[d][1];

                                if (isPossible(cur, nr, nc)) {
                                    visited[nr][nc] = true;
                                    sum += map[nr][nc];
                                    list.add(new int[]{nr, nc});
                                    q.offer(new int[]{nr, nc});
                                }
                            }
                        }
                        if(list.size() > 1) {
                            flag = false;
                            int n = sum / list.size();
                            for (int[] t : list) map[t[0]][t[1]] = n;
                        }
                    }
                }
            }
            day++;
        }

        System.out.println(day - 1);
        br.close();
    }

    static boolean isPossible(int[] cur, int r, int c) {
        if(0 <= r && r < N && 0 <= c && c < N && !visited[r][c]) {
            int n1 = Math.max(map[cur[0]][cur[1]], map[r][c]);
            int n2 = Math.min(map[cur[0]][cur[1]], map[r][c]);
            int diff = n1 - n2;

            return L <= diff && diff <= R;
        }
        return false;
    }
}
