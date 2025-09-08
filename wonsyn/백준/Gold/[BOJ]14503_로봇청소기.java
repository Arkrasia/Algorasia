import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] room, dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        Robot robot = new Robot(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        room = new int[N][M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 0;
        while(true) {
            if(room[robot.r][robot.c] == 0) {
                cnt++;
                room[robot.r][robot.c] = 2;
            }

            boolean possible = false;
            for(int d = 0; d < 4; d++) {
                int nr = robot.r + dir[d][0];
                int nc = robot.c + dir[d][1];
                if(room[nr][nc] == 0) {
                    possible = true;
                    break;
                }
            }
            if(possible) {
                for(int d = 0; d < 4; d++) {
                    robot.change();
                    int nr = robot.r + dir[robot.d][0];
                    int nc = robot.c + dir[robot.d][1];
                    if(room[nr][nc] == 0) {
                        robot.r = nr; robot.c = nc;
                        break;
                    }
                }
            } else {
               int nr = robot.r - dir[robot.d][0];
               int nc = robot.c - dir[robot.d][1];

               if(room[nr][nc] == 1) {
                   break;
               } else {
                   robot.r = nr; robot.c = nc;
               }
            }

        }

        System.out.println(cnt);
        br.close();
    }

    public static class Robot {
        int r, c, d;

        Robot(int r, int c, int d) {
            this.r = r; this.c = c; this.d = d;
        }

        public void change() {
            if(--d == -1) d = 3;
        }
    }
}
