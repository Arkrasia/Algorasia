import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static boolean[][] map;
    static int[][][] dp;
    static int[][] dir = {{0, 1}, {1, 0}, {1, 1}};
    static int[][] nexts = {{0, 2}, {1, 2}, {0, 1, 2}};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new boolean[N][N];
        dp = new int[N][N][3];

        StringTokenizer st;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken()) == 0;
            }
        }

        dp[0][1][0] = 1;
        for(int r = 0; r < N; r++) {
            for(int c = 1; c < N; c++) {
                for(int curD = 0; curD < 3; curD++) {
                    if(dp[r][c][curD] == 0) continue;

                    int[] next = nexts[curD];
                    boolean[] check = new boolean[3];
                    for(int d = 0; d < 3; d++) {
                        int nr = r + dir[d][0], nc = c + dir[d][1];

                        if (nr < N && nc < N && map[nr][nc]) {
                            if (d == 2) check[d] = check[0] && check[1];
                            else check[d] = true;
                        }
                    }

                    for (int d : next) {
                        if (check[d]) {
                            dp[r + dir[d][0]][c + dir[d][1]][d] += dp[r][c][curD];
                        }
                    }
                }
            }
        }

//        for(int d = 0; d < 3; d++) {
//            for (int i = 0; i < N; i++) {
//                for (int j = 0; j < N; j++) {
//                    System.out.print(dp[i][j][d]);
//                }
//                System.out.println();
//            }
//            System.out.println();
//        }

        int cnt = 0;
        for(int d = 0; d < 3; d++) {
            cnt += dp[N - 1][N - 1][d];
        }
        System.out.println(cnt);

        br.close();
    }
}
