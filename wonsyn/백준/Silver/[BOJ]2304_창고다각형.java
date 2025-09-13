import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        int max = Integer.MIN_VALUE;
        int[][] arr = new int[N][2];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            max = Math.max(arr[i][1], max);
        }

        Arrays.sort(arr, (o1, o2) -> o1[0] - o2[0]);

        int f = -1, b = -1;
        for(int i = 0; i < N; i++) {
            if(arr[i][1] == max) {
                f = i; break;
            }
        }
        for(int i = N - 1; i >= 0 ; i--) {
            if(arr[i][1] == max) {
                b = i; break;
            }
        }

        int idx = 0;
        int ans = 0;
        int h = -1;
        while(idx < f) {
            int x = arr[idx][0];
            h = Math.max(h, arr[idx][1]);
            ans += h * (arr[++idx][0] - x);
        }
        idx = N - 1;
        h = -1;
        while(idx > b) {
            int x = arr[idx][0];
            h = Math.max(h, arr[idx][1]);
            ans += h * (x - arr[--idx][0]);
        }
        ans += max * (arr[b][0] - arr[f][0] + 1);

        System.out.println(ans);
        br.close();
    }
}
