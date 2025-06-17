import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] bd;
    static boolean[] left;
    static int cur;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        bd = new int[N][2]; // 0: 좌, 1: 우
        left = new boolean[N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            left[i] = d == 1;
            if(left[i]) {
                bd[i][0] = L - l;
                bd[i][1] = L;
            } else {
                bd[i][0] = 0;
                bd[i][1] = l;
            }
        }

        cur = N - 1;
        int time = 0;
        while (true) {
            up();
            if(cur == 0) break;
            move(N, L);
            time++;
        }

        System.out.println(time);
        br.close();
    }

    public static void up() {
        while (cur != 0) {
            if((bd[cur - 1][1] >= bd[cur][0] && bd[cur - 1][0] <= bd[cur][0])   // 왼쪽 걸치기
                    || (bd[cur - 1][0] <= bd[cur][1] && bd[cur - 1][1] >= bd[cur][1])   // 오른쪽 걸치기
                    || (bd[cur - 1][0] >= bd[cur][0] && bd[cur - 1][1] <= bd[cur][1])   // 위가 작음
                    || (bd[cur - 1][0] <= bd[cur][0] && bd[cur - 1][1] >= bd[cur][1])) {    // 위가 큼
                cur--;
            } else {
                break;
            }
        }
    }

    public static void move(int N, int L) {
        for(int i = 0; i < N; i++) {
            if (left[i]) {
                bd[i][0]--;
                bd[i][1]--;
                if(bd[i][0] == 0) left[i] = false;
            } else {
                bd[i][0]++;
                bd[i][1]++;
                if(bd[i][1] == L) left[i] = true;
            }
        }
    }
}
