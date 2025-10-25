import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, max = Integer.MIN_VALUE;
    static int[] arr, selected;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N];
        selected = new int[N];
        visited = new boolean[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        calc(0);

        System.out.println(max);
        br.close();
    }

    static void calc(int cnt) {
        if(cnt == N) {
            int sum = 0;
            for(int i = 0; i < N - 1; i++) {
                sum += Math.abs(selected[i] - selected[i + 1]);
            }
            max = Math.max(sum, max);
        }

        for(int i = 0; i < N; i++) {
            if(!visited[i]) {
                selected[cnt] = arr[i];
                visited[i] = true;
                calc(cnt + 1);
                visited[i] = false;
            }
        }
    }
}
