import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int cnt = 0;
        int ans = -1;
        boolean[] arr = new boolean[N + 1];
        for(int i = 2; i <= N; i++) {
            if(!arr[i]) {
                arr[i] = true;
                cnt++;
                if(cnt == K) {
                    ans = i;
                    break;
                }
                for(int j = 2; i * j <= N; j++) {
                    if(!arr[i * j]) {
                        arr[i * j] = true;
                        cnt++;
                        if(cnt == K) {
                            ans = i * j;
                            break;
                        }
                    }
                }
                if(ans != -1) {
                    break;
                }
            }
        }

        System.out.println(ans);
        br.close();
    }
}
