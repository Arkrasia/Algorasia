import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] parents;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        parents = new int[N + 1];
        for(int i = 1; i <= N; i++) parents[i] = i;

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            union(a, b);
        }

        st = new StringTokenizer(br.readLine());

        int cnt = 0;
        int cur = find(Integer.parseInt(st.nextToken()));
        for(int j = 0; j < N - 1; j++) {
            int next = find(Integer.parseInt(st.nextToken()));

            if(cur != next) cnt++;
            cur = next;
        }

        System.out.println(cnt);
        br.close();
    }

    public static void union(int a, int b) {
        int n1 = find(a);
        int n2 = find(b);

        if(n1 == n2) return;

        if(n1 > n2) {
            parents[n1] = n2;
        } else {
            parents[n2] = n1;
        }
    }

    public static int find(int a) {
        if (parents[a] == a) return a;

        return parents[a] = find(parents[a]);
    }
}
