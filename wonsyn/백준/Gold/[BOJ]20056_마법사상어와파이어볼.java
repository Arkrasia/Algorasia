import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int[][] dir = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        ArrayList<FireBall> list = new ArrayList<>();
        ArrayList<FireBall>[][] count = new ArrayList[N + 1][N + 1];
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                count[i][j] = new ArrayList<>();
            }
        }


        for(int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            FireBall f = new FireBall(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            list.add(f);
        }

        for(int k = 0; k < K; k++) {
            for(FireBall f : list) {
                f.r += dir[f.d][0] * f.s;
                f.c += dir[f.d][1] * f.s;
                while (f.r < 1) f.r += N; while (f.r > N) f.r -= N;
                while (f.c < 1) f.c += N; while (f.c > N) f.c -= N;
                count[f.r][f.c].add(f);
            }

            for(int i = 1; i <= N; i++) {
                for(int j = 1; j <= N; j++) {
                    if(count[i][j].size() < 2) {
                        count[i][j].clear();
                        continue;
                    }

                    int ms = 0, ss = 0, odd = 0, even = 0;
                    for(FireBall f : count[i][j]) {
                        ms += f.m;
                        ss += f.s;
                        if(f.d % 2 == 0) even++;
                        else odd++;
                        list.remove(f);
                    }

                    int size = count[i][j].size();
                    count[i][j].clear();

                    ms /= 5;
                    if(ms == 0) continue;
                    ss /= size;
                    if(odd == 0 || even == 0) {
                        for(int d = 0; d < 8; d += 2) {
                            list.add(new FireBall(i, j, ms, ss, d));
                        }
                    } else {
                        for(int d = 1; d < 8; d += 2) {
                            list.add(new FireBall(i, j, ms, ss, d));
                        }
                    }
                }
            }
        }

        int sum = 0;
        for(FireBall f : list) {
            sum += f.m;
        }


        System.out.println(sum);
        br.close();
    }

    static class FireBall {
        int r, c, m, s, d;

        FireBall(int r, int c, int m, int s, int d) {
            this.r = r; this.c = c; this.m = m; this.s = s; this.d = d;
        }
    }
}
