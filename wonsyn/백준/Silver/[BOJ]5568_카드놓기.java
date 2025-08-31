import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    static int N, K;
    static String[] arr, selected;
    static boolean[] visited;
    static Set<Integer> set;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        set = new HashSet<>();

        arr = new String[N];
        selected = new String[K];
        visited = new boolean[N];

        for(int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }

        perm(0);

        System.out.println(set.size());
        br.close();
    }

    public static void perm(int cnt) {
        if(cnt == K) {
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < K; i++) sb.append(selected[i]);
            set.add(Integer.parseInt(sb.toString()));
            return;
        }

        for(int i = 0; i < N; i++) {
            if(!visited[i]) {
                selected[cnt] = arr[i];
                visited[i] = true;
                perm(cnt + 1);
                visited[i] = false;
            }
        }
    }
}
