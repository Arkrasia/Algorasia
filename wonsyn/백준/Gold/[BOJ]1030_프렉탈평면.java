import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int s, N, K, R1, R2, C1, C2, center;
    static boolean[][] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        s = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        R1 = Integer.parseInt(st.nextToken());
        R2 = Integer.parseInt(st.nextToken());
        C1 = Integer.parseInt(st.nextToken());
        C2 = Integer.parseInt(st.nextToken());
        int size = (int)Math.pow(N, s);
        center = (N - K) / 2;

        arr = new boolean[R2 - R1 + 1][C2 - C1 + 1];

        recursion(0, 0, size, false);

        StringBuilder sb = new StringBuilder();
        for(int r = 0; r < arr.length; r++) {
            for(int c = 0; c < arr[0].length; c++) {
                sb.append(arr[r][c] ? 1 : 0);
            }
            sb.append("\n");
        }

        System.out.print(sb);
        br.close();
    }

    static void recursion(int r, int c, int size, boolean black) {
        if(r + size <= R1 || R2 < r || c + size <= C1 || C2 < c) return;
        if(size == 1) {
            arr[r - R1][c - C1] = black;
            return;
        }

        int ns = size / N;

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                int nr = r + (i * ns), nc = c + (j * ns);

                recursion(nr, nc, ns, black || inRange(i, j));
            }
        }
    }

    static boolean inRange(int r, int c) {
        return center <= r && r < N - center && center <= c && c < N - center;
    }
}
