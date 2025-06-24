import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] dir = {{0, 1}, {1, 0}};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        char[][] room = new char[R][C];

        for(int i = 0; i < R; i++) {
            String s = br.readLine();
            for(int j = 0; j < C; j++) {
                room[i][j] = s.charAt(j);
            }
        }

        int cnt = 0;
        for(int r = 0; r < R; r++) {
            for(int c = 0; c < C; c++) {
                char cur = room[r][c];

                if(cur == '0') continue;

                int d = cur == '-' ? 0 : 1;
                int nr = r, nc = c;
                while(0 <= nr && nr < R && 0 <= nc && nc < C && room[nr][nc] == cur) {
                    room[nr][nc] = '0';
                    nr += dir[d][0];
                    nc += dir[d][1];
                }
                cnt++;
            }
        }

        System.out.println(cnt);
        br.close();
    }
}
