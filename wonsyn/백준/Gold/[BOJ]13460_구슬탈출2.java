import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static int N, M;
    static char[][] map;
    static boolean visited[][][][]; // rr, rc, br, bc

    public static void main(String[] args) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        visited = new boolean[N][M][N][M];

        Queue<int[]> rq = new ArrayDeque<>();
        Queue<int[]> bq = new ArrayDeque<>();
        int r1 = -1, r2 = -1, b1 = -1, b2 = -1;
        for(int i = 0; i < N; i++) {
            String s = bufferedReader.readLine();
            for(int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j);
                if(map[i][j] == 'R') {
                    rq.offer(new int[]{i, j, 0});
                    r1 = i; r2 = j;
                    map[i][j] = '.';
                }
                if(map[i][j] == 'B') {
                    bq.offer(new int[]{i, j, 0});
                    b1 = i; b2 = j;
                    map[i][j] = '.';
                }
            }
        }

        visited[r1][r2][b1][b2] = true;
        bufferedReader.close();

        int ans = -1;

        done:
        while(!rq.isEmpty()) {
            int[] curR = rq.poll();
            int[] curB = bq.poll();

            if(curR[2] == 10) break;

            int rr = curR[0], rc = curR[1];
            int br = curB[0], bc = curB[1];

            next:
            for(int d = 0; d < 4; d++) {
                boolean done = false;
                int nrr, nrc;
                int ri = 1;
                while(true) {
                    nrr = rr + dir[d][0] * ri;
                    nrc = rc + dir[d][1] * ri;

                    if(map[nrr][nrc] == '#') {
                        ri--;
                        break;
                    } else if(map[nrr][nrc] == '.') {
                        ri++;
                    } else if(map[nrr][nrc] == 'O') {
                        ans = curR[2] + 1;
                        done = true;
                        break;
                    }
                }


                int nbr, nbc;
                int bi = 1;
                while(true) {
                    nbr = br + dir[d][0] * bi;
                    nbc = bc + dir[d][1] * bi;

                    if(map[nbr][nbc] == '#') {
                        bi--;
                        break;
                    } else if(map[nbr][nbc] == '.') {
                        bi++;
                    } else if(map[nbr][nbc] == 'O') {
                        if(done) ans = -1;
                        continue next;
                    }
                }

                if(done) break done;

                nrr = rr + dir[d][0] * ri;
                nrc = rc + dir[d][1] * ri;

                nbr = br + dir[d][0] * bi;
                nbc = bc + dir[d][1] * bi;

                if(nrr == nbr && nrc == nbc) {
                    if(ri > bi) {
                        nrr -= dir[d][0];
                        nrc -= dir[d][1];
                    } else {
                        nbr -= dir[d][0];
                        nbc -= dir[d][1];
                    }
                }
                if(!visited[nrr][nrc][nbr][nbc]) {
                    visited[nrr][nrc][nbr][nbc] = true;
                    rq.offer(new int[]{nrr, nrc, curR[2] + 1});
                    bq.offer(new int[]{nbr, nbc, curB[2] + 1});
                }
            }
        }

        System.out.println(ans);
    }
}
