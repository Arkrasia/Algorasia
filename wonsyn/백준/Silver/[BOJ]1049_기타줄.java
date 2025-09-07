import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        for(int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            min1 = Math.min(a, min1);
            min2 = Math.min(b, min2);
        }

        int ans = 0;
        ans += Math.min(min1 * (N / 6), (min2 * 6) * (N / 6));
        N %= 6;
        int temp = N * min2;
        ans += Math.min(temp, min1);

        System.out.println(ans);
        br.close();
    }
}
