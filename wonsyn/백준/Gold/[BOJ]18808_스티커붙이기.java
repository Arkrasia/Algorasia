import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        boolean[][] nb = new boolean[N][M];

        Queue<Sticker> q = new ArrayDeque<>();

        for(int k = 0; k < K; k++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            boolean[][] shape = new boolean[r][c];
            for(int i = 0; i < r; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < c; j++) {
                    shape[i][j] = st.nextToken().charAt(0) == '1';
                }
            }
            q.offer(new Sticker(r, c, shape));
        }

        nextS:
        while(!q.isEmpty()) {
            Sticker cur = q.poll();
            int min = Math.min(cur.r, cur.c);

            boolean isPossible = false;

            while(true) {
                for (int i = 0; i <= N - min; i++) {
                    for (int j = 0; j <= M - min; j++) {
                        if (i + cur.r > N || j + cur.c > M) continue;

                        out:
                        for (int x = 0; x < cur.r; x++) {
                            for (int y = 0; y < cur.c; y++) {
                                if (nb[i + x][j + y] && cur.shape[x][y]) {
                                    break out;
                                }

                                if (x == cur.r - 1 && y == cur.c - 1) isPossible = true;
                            }
                        }

                        // 붙이기
                        if (isPossible) {
                            for (int x = 0; x < cur.r; x++) {
                                for (int y = 0; y < cur.c; y++) {
                                    if (cur.shape[x][y]) nb[i + x][j + y] = true;
                                }
                            }
                            continue nextS;
                        }
                    }
                }

                if(cur.cnt == 3) break;
                cur.rotate();
            }
        }

        int cnt = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(nb[i][j]) cnt++;
            }
        }

        System.out.println(cnt);
        br.close();
    }

    static class Sticker {
        int r, c;
        boolean[][] shape;
        int cnt;

        Sticker(int r, int c, boolean[][] shape) {
            this.r = r; this.c = c; this.shape = shape;
            cnt = 0;
        }

        boolean rotate() {
            if(cnt == 3) return false;

            boolean[][] temp = new boolean[c][r];

            for(int i = 0; i < r; i++) {
                for(int j = 0; j < c; j++) {
                    temp[j][r - i - 1] = shape[i][j];
                }
            }

            int t = r; r = c; c = t;
            shape = temp;
            cnt++;
            return true;
        }
    }
}
