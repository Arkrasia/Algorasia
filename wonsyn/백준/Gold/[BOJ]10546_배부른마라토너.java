import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();

        for(int i = 0; i < N; i++) {
            String s = br.readLine();
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        for(int i = 0; i < N - 1; i++) {
            String s = br.readLine();
            int n = map.get(s);
            if(n == 1) map.remove(s);
            else map.put(s, n - 1);
        }

        System.out.println(map.keySet().toArray()[0]);
        br.close();
    }
}
