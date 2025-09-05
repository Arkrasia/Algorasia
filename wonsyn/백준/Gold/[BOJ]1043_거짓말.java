import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static int[] parents;
    static Set<Integer> knows;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        if(K == 0) {
            System.out.println(M);
            return;
        }

        knows = new HashSet<>();
        while(st.hasMoreTokens()) {
            knows.add(Integer.parseInt(st.nextToken()));
        }

        parents = new int[N + 1];
        for(int i = 1; i <= N; i++) {
            parents[i] = i;
        }

        List<Integer>[] party = new ArrayList[M];
        for(int i = 0; i < M; i++) party[i] = new ArrayList<>();

        for(int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            int root = Integer.parseInt(st.nextToken());
            party[m].add(root);
            for(int i = 1; i < cnt; i++) {
                int child = Integer.parseInt(st.nextToken());
                union(root, child);
                party[m].add(child);
            }
        }

        int cnt = 0;
        for(List<Integer> list : party) {
            boolean flag = false;
            for(int n : list) {
                if(knows.contains(find(parents[n]))) {
                    flag = true;
                    break;
                }
            }
            if(!flag) cnt++;
        }

        System.out.println(cnt);
        br.close();
    }

    public static int find(int x) {
        if(parents[x] == x) return x;
        return parents[x] = find(parents[x]);
    }

    public static void union(int x, int y) {
        int rx = find(x);
        int ry = find(y);
        if(knows.contains(ry)) {
            int temp = ry;
            ry = rx;
            rx = temp;
        }
        parents[ry] = rx;
    }
}
