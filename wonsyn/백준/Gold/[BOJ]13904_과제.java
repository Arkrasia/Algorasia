import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] work;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        work = new int[N][2];

        int day = Integer.MIN_VALUE;
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            day = Math.max(d, day);
            work[i][0] = d; work[i][1] = w;
        }

        int score = 0;
        for(int i = day; i > 0; i--) {
            score += getMax(i);
        }

        System.out.println(score);
        br.close();
    }

    public static int getMax(int day) {
        int idx = -1;
        int res = 0;

        for(int i = 0; i < work.length; i++) {
            if(work[i][0] >= day && work[i][1] > res) {
                idx = i;
                res = work[i][1];
            }
        }
        if(res == 0) {
            return 0;
        } else {
            work[idx][1] = -1;
            return res;
        }
    }
}
