import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] calendar = new int[366];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            for(int d = start; d <= end; d++) {
                calendar[d]++;
            }
        }
        br.close();

        int day = 0;
        int max = 0;
        int ans = 0;
        for(int i = 1; i <= 365; i++) {
            if(calendar[i] == 0) {
                ans += day * max;

                day = 0; max = 0;
                continue;
            }

            max = Math.max(max, calendar[i]);
            day++;
        }

        ans += day * max;

        System.out.println(ans);
    }
}
