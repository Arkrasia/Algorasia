import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, q;
    static long k;
    static int[] arr;
    static long[] fact;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        fact = new long[N];
        fact[0] = 1;
        if(N != 1) fact[1] = 1;
        for(int i = 2; i < N; i++) {
            fact[i] = fact[i - 1] * i;
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();

        q = Integer.parseInt(st.nextToken());

        if(q == 1) {
            k = Long.parseLong(st.nextToken());
            boolean[] used = new boolean[N + 1];
            int[] ans = new int[N];

            int idx = 0;
            int cur = N - 1;
            while(idx < N) {
                int cnt = 0;
                while (k > fact[cur]) {
                    cnt++;
                    k -= fact[cur];
                }

                int temp = 0;
                for (int i = 1; i <= N; i++) {
                    if (!used[i]) {
                        if (temp != cnt) {
                            temp++;
                        } else {
                            used[i] = true;
                            ans[idx++] = i;
                            break;
                        }
                    }
                }
                cur--;
            }
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < N; i++) {
                sb.append(ans[i]).append(" ");
            }
            System.out.println(sb);
        } else {
            arr = new int[N];
            for(int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            boolean[] used = new boolean[N + 1];
            long ans = 0;
            for(int i = 0; i < N; i++) {
                int cnt = 0;
                for(int j = 1; j < arr[i]; j++) {
                    if(!used[j]) cnt++;
                }
                used[arr[i]] = true;
                ans += fact[N - 1 - i] * cnt;
            }

            System.out.println(ans + 1);
        }
    }
}
