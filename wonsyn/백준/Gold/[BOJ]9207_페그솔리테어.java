import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static int min, minMove;
    static char[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        map = null;
        StringBuilder sb = new StringBuilder();
        for(int t = 0; t < T; t++) {
            min = Integer.MAX_VALUE; minMove = Integer.MAX_VALUE;

            if(map == null) map = new char[5][9];

            int total = 0;
            for(int i = 0; i < 5; i++) {
                String s = br.readLine();
                for(int j = 0; j < 9; j++) {
                    map[i][j] = s.charAt(j);
                    if(map[i][j] == 'o') total++;
                }
            }
            if(t != T - 1) br.readLine();

            for(int i = 0; i < 5; i++) {
                for(int j = 0; j < 9; j++) {
                    if(map[i][j] == 'o') {
                        move(i, j, total, 0);
                    }
                }
            }

            sb.append(min).append(" ").append(minMove).append("\n");
        }

        System.out.println(sb);
        br.close();
    }

    public static void move(int r, int c, int total, int cnt) {
        if(total <= min) {
            min = total;
            minMove = cnt;
        }

        for(int d = 0; d < 4; d++) {
            int nr = r + dir[d][0];
            int nc = c + dir[d][1];

            if(0 <= nr && nr < 5 && 0 <= nc && nc < 9 && map[nr][nc] == 'o') {
                int nnr = nr + dir[d][0];
                int nnc = nc + dir[d][1];
                if(0 <= nnr && nnr < 5 && 0 <= nnc && nnc < 9 && map[nnr][nnc] == '.') {
                    map[r][c] = '.';
                    map[nr][nc] = '.';
                    map[nnr][nnc] = 'o';
                    for(int i = 0; i < 5; i++) {
                        for(int j = 0; j < 9; j++) {
                            if(map[i][j] == 'o') move(i, j, total - 1, cnt + 1);
                        }
                    }
                    map[r][c] = 'o';
                    map[nr][nc] = 'o';
                    map[nnr][nnc] = '.';
                }
            }
        }
    }
}
