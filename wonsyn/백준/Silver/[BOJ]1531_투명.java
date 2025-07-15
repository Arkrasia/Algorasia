import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)  throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] picture = new int[101][101];

        for(int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken()), y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken()), y2 = Integer.parseInt(st.nextToken());

            for(int i = x1; i <= x2; i++) {
                for(int j = y1; j <= y2; j++) {
                    picture[i][j]++;
                }
            }
        }

        int cnt = 0;
        for(int i = 1; i < 101; i++) {
            for(int j = 1; j < 101; j++) {
                if(picture[i][j] > M) cnt++;
            }
        }

        System.out.println(cnt);
        br.close();
    }
}
