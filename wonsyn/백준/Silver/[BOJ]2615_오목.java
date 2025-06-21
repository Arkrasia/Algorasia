import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr = new int[20][20];
    static int[][] dir = {{1, 0}, {1, 1}, {0, 1}, {-1, 1}};
    // 좌상, 상, 좌, 좌하 제외 -> 하 우하 우 우상
    static int[][] rev = {{-1, 0}, {-1, -1}, {0, -1}, {1, -1}};
    // 상, 좌상, 좌, 좌하

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st;
        for(int i = 1; i < 20; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j < 20; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int c = 1; c < 20; c++) {
            for(int r = 1; r < 20; r++) {
                if(arr[r][c] != 0 && check(r, c)) {
                    sb.append(arr[r][c]).append("\n");
                    sb.append(r).append(" ").append(c);
                    System.out.println(sb);
                    br.close();
                    System.exit(0);
                }
            }
        }

        System.out.println(0);
        br.close();
    }

    public static boolean check(int r, int c) {
        int cur = arr[r][c];
        next: for(int d = 0; d < 4; d++) {
            for(int i = 1; i < 5; i++) {
                int nr = r + dir[d][0] * i;
                int nc = c + dir[d][1] * i;
                if(0 >= nr || nr >= 20 || 0 >= nc || nc >= 20 || cur != arr[nr][nc]) {
                    continue next;
                }
            }
            int nr = r + dir[d][0] * 5;
            int nc = c + dir[d][1] * 5;
            if(0 < nr && nr < 20 && 0 < nc && nc < 20 && cur == arr[nr][nc]) {
                continue next;
            }
            nr = r + rev[d][0];
            nc = c + rev[d][1];
            if(0 < nr && nr < 20 && 0 < nc && nc < 20 && cur == arr[nr][nc]) {
                continue next;
            }
            return true;
        }
        return false;
    }
}
