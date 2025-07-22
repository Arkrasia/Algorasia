import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, K, L, time;
    static boolean[][] apple;
    static int[][] snake, dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        time = 0;

        apple = new boolean[N][N];
        StringTokenizer st;
        for(int k = 0; k < K; k++) {
            st = new StringTokenizer(br.readLine());
            apple[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = true;
        }

        L = Integer.parseInt(br.readLine());
        snake = new int[N][N];
        for(int i = 0; i < N; i++) Arrays.fill(snake[i], 4);
        snake[0][0] = 0;

        Queue<int[]> q = new ArrayDeque<>();
        for(int l = 0; l < L; l++) {
            st = new StringTokenizer(br.readLine());
            q.offer(new int[]{
                    Integer.parseInt(st.nextToken()),
                    st.nextToken().charAt(0) == 'D' ? 1 : -1
            });
        }
        br.close();

        int[] head = {0, 0};
        int[] tail = {0, 0};
        while(true) {
            time++;
            int nr = head[0] + dir[snake[head[0]][head[1]]][0];
            int nc = head[1] + dir[snake[head[0]][head[1]]][1];

            if(nr < 0 || N <= nr || nc < 0 || N <= nc
                    || snake[nr][nc] != 4) {
                break;
            }

            snake[nr][nc] = snake[head[0]][head[1]];
            head[0] = nr; head[1] = nc;

            if(apple[nr][nc]) {
               apple[nr][nc] = false;
            } else {
                int d = snake[tail[0]][tail[1]];
                snake[tail[0]][tail[1]] = 4;
                tail[0] += dir[d][0];
                tail[1] += dir[d][1];
            }

            if(!q.isEmpty() && q.peek()[0] == time) {
                snake[nr][nc] = changeDir(snake[nr][nc], q.poll()[1]);
            }
        }

        System.out.println(time);
    }

    static int changeDir(int d, int c) {
        return (d + 4 + c) % 4;
    }
}
