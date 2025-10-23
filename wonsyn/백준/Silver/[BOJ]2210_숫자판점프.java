import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static int[][] arr;
    static Set<Integer> set;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        arr = new int[5][5];
        set = new HashSet<>();

        for(int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 5; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                dfs(i, j, 1, new StringBuilder().append(arr[i][j]));
            }
        }

        System.out.println(set.size());
        br.close();
    }

    static void dfs(int x, int y, int cnt, StringBuilder sb) {
        if(cnt == 6) {
            int n = Integer.parseInt(sb.toString());
            set.add(n);
            return;
        }

        for(int d = 0; d < 4; d++) {
            int nx = x + dir[d][0];
            int ny = y + dir[d][1];
            if(0 <= nx && nx < 5 && 0 <= ny && ny < 5) {
                dfs(nx, ny, cnt + 1, sb.append(arr[nx][ny]));
                sb.setLength(sb.length() - 1);
            }
        }
    }
}
