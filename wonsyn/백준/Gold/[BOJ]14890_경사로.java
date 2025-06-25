import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, L;
    static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 0;
        nextR:
        for (int r = 0; r < N; r++) {
            boolean[] check = new boolean[N];
            for (int c = 0; c < N; c++) {
                if (c + 1 < N && map[r][c] == map[r][c + 1]) continue;  // 같을 때

                if (c + 1 < N && Math.abs(map[r][c] - map[r][c + 1]) == 1) {  // 1차이 날 때
                    if (map[r][c] > map[r][c + 1]) { // 뒤가 작을 때
                        for (int k = 2; k <= L; k++) {
                            if (c + k >= N || map[r][c + 1] != map[r][c + k]) {
                                continue nextR;
                            }
                        }
                        for (int k = 1; k <= L; k++) {
                            check[c + k] = true;
                        }
                        c = c + L - 1;
                    } else {    // 뒤가 클 때
                        for (int k = 0; k < L; k++) {
                            if (c - k < 0 || check[c - k] || map[r][c] != map[r][c - k]) {
                                continue nextR;
                            }
                        }
                        for (int k = 0; k < L; k++) {
                            check[c - k] = true;
                        }
                    }
                } else if(c + 1 < N && Math.abs(map[r][c] - map[r][c + 1]) > 1){
                    continue nextR;  // 차이가 클 때
                }
            }
            cnt++;
        }

        nextC:
        for (int c = 0; c < N; c++) {
            boolean[] check = new boolean[N];
            for (int r = 0; r < N; r++) {
                if (r + 1 < N && map[r][c] == map[r + 1][c]) continue;  // 같을 때

                if (r + 1 < N && Math.abs(map[r][c] - map[r + 1][c]) == 1) {  // 1차이 날 때
                    if (map[r][c] > map[r + 1][c]) { // 뒤가 작을 때
                        for (int k = 2; k <= L; k++) {
                            if (r + k >= N || map[r + 1][c] != map[r + k][c]) {
                                continue nextC;
                            }
                        }
                        for (int k = 1; k <= L; k++) {
                            check[r + k] = true;
                        }
                        r = r + L - 1;
                    } else {    // 뒤가 클 때
                        for (int k = 0; k < L; k++) {
                            if (r - k < 0 || check[r - k] || map[r][c] != map[r - k][c]) {
                                continue nextC;
                            }
                        }
                        for (int k = 0; k < L; k++) {
                            check[r - k] = true;
                        }
                    }
                } else if(r + 1 < N && Math.abs(map[r][c] - map[r + 1][c]) > 1){
                    continue nextC;  // 차이가 클 때
                }
            }
            cnt++;
        }

        System.out.println(cnt);
        br.close();
    }
}
