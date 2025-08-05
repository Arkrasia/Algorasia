import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr, cnt;
    static int[][] tc = {{1, 2, 3}, {1, 3, 2}, {2, 1, 3}, {2, 3, 1}, {3, 1, 2}, {3, 2, 1}};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();

        arr = new int[N];
        cnt = new int[4];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            cnt[arr[i]]++;
        }

        int min = Integer.MAX_VALUE;
        for(int[] cur : tc) {
            int idx = 0;
            int[][] swap = new int[4][4];
            for(int num : cur) {
                for(int i = 0; i < cnt[num]; i++) {
                    if(arr[idx] != num) {
                        swap[num][arr[idx]]++;
                    }
                    idx++;
                }
            }
            int res = swap[cur[0]][cur[1]] + swap[cur[0]][cur[2]]
                    + Math.max(swap[cur[1]][cur[2]], swap[cur[2]][cur[1]]);
            min = Math.min(min, res);
        }

        System.out.println(min);
    }
}
