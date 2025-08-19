import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] tree, arr;
    static int min;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[N + 1];
        for(int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        tree = new int[N * 4];

        init(1, N, 1);
        StringBuilder sb = new StringBuilder();
        for(int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            min = Integer.MAX_VALUE;

            getMin(1, N, 1, a, b);
            sb.append(min).append("\n");
        }


        System.out.println(sb);
        br.close();
    }

    public static void init(int start, int end, int node) {
        if(start == end) {
            tree[node] = arr[start];
            return;
        }

        int mid = (start + end) / 2;
        init(start, mid, node * 2);
        init(mid + 1, end, node * 2 + 1);

        tree[node] = Math.min(tree[node * 2], tree[node * 2 + 1]);
    }

    public static void getMin(int start, int end, int node, int left, int right) {
        if(end < left || right < start) return;
        if(left <= start && end <= right) {
            min = Math.min(min, tree[node]);
            return;
        }

        int mid = (start + end) / 2;
        getMin(start, mid, node * 2, left, right);
        getMin(mid + 1, end, node * 2 + 1, left, right);
    }
}
