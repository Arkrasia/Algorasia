import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] person = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            person[i] = Integer.parseInt(st.nextToken());
        }

        int[] ans = new int[N];
        for(int i = 1; i <= N; i++) {
            int p = person[i];
            int cnt = 0;
            int b = 0;
            while(cnt != p) {
                if(ans[b++] == 0) cnt++;
            }

            while(ans[b] != 0) b++;
            ans[b] = i;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            sb.append(ans[i]).append(" ");
        }
        System.out.println(sb);
        br.close();
    }
}
