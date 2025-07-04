import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] map = new int[101][101];

        for(int i = 0; i < 101; i++) {
            Arrays.fill(map[i], 0);
        }

        for(int p = 0; p < N; p++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            for(int r = x; r < x + 10; r++) {
                for(int c = y; c < y + 10; c++) {
                    map[r][c] = 1;
                }
            }
        }

        for(int j = 0; j < 101; j++) {
            for(int i = 1; i < 101; i++) {
                if(map[i][j] != 0 && map[i - 1][j] != 0) {
                    map[i][j] += map[i - 1][j];
                }
            }
        }

        int ans = 0;
        for(int i = 0; i < 101; i++) {
            for(int j = 0; j < 101; j++) {
                int h = Integer.MAX_VALUE;

                for(int k = j; k < 101; k++) {
                    h = Math.min(h, map[i][k]);
                    if(h == 0) break;
                    ans = Math.max(ans, h * (k - j + 1));
                }
            }
        }

        System.out.println(ans);
        br.close();
    }
}
