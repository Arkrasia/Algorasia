import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 1; i < N; i++) {
            arr[i][0] += arr[i - 1][0];
        }
        for(int i = 1; i < M; i++) {
            arr[0][i] += arr[0][i - 1];
        }
        for(int i = 1; i < N; i++) {
            for(int j = 1; j < M; j++) {
                arr[i][j] += arr[i - 1][j] + arr[i][j - 1] - arr[i - 1][j - 1];
            }
        }

        StringBuilder sb = new StringBuilder();
        int K = Integer.parseInt(br.readLine());
        for(int k = 0; k < K; k++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken()) - 1;
            int j = Integer.parseInt(st.nextToken()) - 1;
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;

            int ans = arr[x][y];
            if(i - 1 >= 0 && j - 1 >= 0) ans += arr[i - 1][j - 1];
            if(i - 1 >= 0) ans -= arr[i - 1][y];
            if(j - 1 >= 0) ans -= arr[x][j - 1];
            sb.append(ans).append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}
