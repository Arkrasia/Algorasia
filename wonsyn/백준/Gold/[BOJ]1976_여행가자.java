import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] parent;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        parent = new int[N + 1];

        for(int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++) {
                if(Integer.parseInt(st.nextToken()) == 1) {
                    union(i, j);
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        int root = find(Integer.parseInt(st.nextToken()));
        for(int i = 1; i < M; i++) {
            if(find(Integer.parseInt(st.nextToken())) != root){
                System.out.println("NO");
                br.close();
                return;
            }
        }

        System.out.println("YES");
        br.close();
    }

    public static void union(int x, int y) {
        x = find(x); y = find(y);

        if(x != y) {
            parent[Math.max(x, y)] = Math.min(x, y);
        }
    }

    public static int find(int c) {
        if(parent[c] == c)
            return c;

        return parent[c] = find(parent[c]);
    }
}
