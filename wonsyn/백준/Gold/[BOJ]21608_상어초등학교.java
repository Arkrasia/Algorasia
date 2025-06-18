import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static int[][] dir = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}}; // 상 좌 우 하

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;

        Set<Integer>[] like = new Set[N * N + 1];
        int[] seq = new int[N * N];
        int[][] map = new int[N + 1][N + 1];

        for(int i = 0; i < N * N; i++) {
            st = new StringTokenizer(br.readLine());

            int student = Integer.parseInt(st.nextToken());
            seq[i] = student;
            like[student] = new HashSet();

            for(int j = 0; j < 4; j++) {
                like[student].add(Integer.parseInt(st.nextToken()));
            }
        }


        for(int s = 0; s < N * N; s++) {
            int[][] count = new int[N + 1][N + 1];
            int[][] blank = new int[N + 1][N + 1];
            int maxR = -1, maxC = -1;
            int max = -1;
            for(int r = 1; r <= N; r++) {
                for(int c = 1; c <= N; c++) {
                    if(map[r][c] != 0) continue;

                    for(int d = 0; d < 4; d++) {
                        int nr = r + dir[d][0];
                        int nc = c + dir[d][1];
                        if(0 < nr && nr <= N && 0 < nc && nc <= N) {
                            if(map[nr][nc] == 0) {
                                blank[r][c]++;
                            } else if(like[seq[s]].contains(map[nr][nc])){
                                count[r][c]++;
                            }
                        }
                    }

                    if(count[r][c] > max || (count[r][c] == max && blank[r][c] > blank[maxR][maxC])) {
                        max = count[r][c];
                        maxR = r; maxC = c;
                    }
                }
            }

            map[maxR][maxC] = seq[s];
        }

        int sum = 0;
        for(int r = 1; r <= N; r++) {
            for(int c = 1; c <= N; c++) {
                int cnt = 0;
                for(int d = 0; d < 4; d++) {
                    int nr = r + dir[d][0];
                    int nc = c + dir[d][1];
                    if(0 < nr && nr <= N && 0 < nc && nc <= N && like[map[r][c]].contains(map[nr][nc])) {
                        cnt++;
                    }
                }
                if (cnt != 0) {
                    sum += Math.pow(10, cnt - 1);
                }
            }
        }

        System.out.println(sum);
        br.close();
    }
}
