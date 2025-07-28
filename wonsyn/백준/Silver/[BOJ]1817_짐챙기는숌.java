import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        if(N == 0) {
            System.out.println(0);
            return;
        }

        st = new StringTokenizer(br.readLine());
        br.close();
        int[] arr = new int[N];

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int idx = 0;
        int cnt = 0;
        int weight = 0;
        while(idx < arr.length) {
            while(idx < arr.length && weight + arr[idx] <= M) {
                weight += arr[idx++];
            }
            cnt++;
            weight = 0;
        }

        System.out.println(cnt);
    }
}
