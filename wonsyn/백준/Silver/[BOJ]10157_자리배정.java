import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int C, R;
    static int[][] hall;
    static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};    // 우 하 좌 상

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        C = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        int person = Integer.parseInt(br.readLine());
        br.close();

        if(person > C * R) {
            System.out.println(0);
            return;
        }

        hall = new int[C][R];

        int num = 1;
        int c = 0, r = 0, d = 0;
        hall[0][0] = num;
        if(person == 1) {
            System.out.println(1 + " " + 1);
            return;
        }

        while(num <= C * R) {
            int nc = c + dir[d][0];
            int nr = r + dir[d][1];

            if(0 > nc || nc >= C || 0 > nr || nr >= R || hall[nc][nr] != 0) {
                d = (d + 1) % 4;
                nc = c + dir[d][0];
                nr = r + dir[d][1];
            }

            hall[nc][nr] = ++num;
            c = nc; r = nr;
            if(hall[nc][nr] == person) break;
        }

        System.out.println((c + 1) + " " + (r + 1));
    }
}
