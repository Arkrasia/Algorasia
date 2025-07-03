import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int[][] dir = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        char[][] map = new char[N][N];
        for(int i = 0; i < N; i++) Arrays.fill(map[i], '0');

        for(int i = 0; i < N; i++) {
            String s = br.readLine();
            for(int j = 0; j < N; j++) {
                char c = s.charAt(j);

                if(c == '.') continue;
                map[i][j] = '*';

                for(int d = 0; d < 8; d++) {
                    int nr = i + dir[d][0];
                    int nc = j + dir[d][1];
                    if(0 <= nr && nr < N && 0 <= nc && nc < N && map[nr][nc] != '*') {
                        map[nr][nc] += c - '0';
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                sb.append(map[i][j] > '9' ? 'M' : map[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}
