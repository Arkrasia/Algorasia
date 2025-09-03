import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for(int tc = 0; tc < T; tc++) {
            int N = Integer.parseInt(br.readLine());

            Map<String, Integer> map = new HashMap<>();

            for(int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                st.nextToken();
                String type = st.nextToken();
                map.put(type, map.getOrDefault(type, 0) + 1);
            }

            Set<String> set = map.keySet();
            int ans = 1;
            for(String key : set) {
                ans *= map.get(key) + 1;
            }
            sb.append(--ans).append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}
