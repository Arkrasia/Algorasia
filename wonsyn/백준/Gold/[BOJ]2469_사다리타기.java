import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        Map<Character, Integer> upper = new HashMap();
        Map<Character, Integer> lower = new HashMap();

        // 상단 입력
        for(int i = 0; i < K; i++) {
            upper.put((char)('A' + i), i);
        }

        //하단 입력
        String s = br.readLine();
        for(int i = 0; i < K; i++) {
            lower.put(s.charAt(i), i);
        }

        int P = -1;
        // 사다리 입력
        char[][] ladder = new char[N][K - 1];
        for(int i = 0; i < N; i++) {
            s = br.readLine();
            for(int j = 0; j < K - 1; j++) {
                ladder[i][j] = s.charAt(j);
            }
            if(ladder[i][0] == '?') P = i;
        }
        br.close();

        Set<Character> up = upper.keySet();
        Set<Character> low = lower.keySet();

        // 상 -> 하
        for(int r = 0; r < P; r++) {
            for(char key : up) {
                int cur = upper.get(key);
                if(cur < K - 1 && ladder[r][cur] == '-') {
                    upper.put(key, cur + 1);
                } else if(cur > 0 && ladder[r][cur - 1] == '-') {
                    upper.put(key, cur - 1);
                }
            }
        }

        // 하 -> 상
        for(int r = N - 1; r > P; r--) {
            for(char key : low) {
                int cur = lower.get(key);
                if(cur < K - 1 && ladder[r][cur] == '-') {
                    lower.put(key, cur + 1);
                } else if(cur > 0 && ladder[r][cur - 1] == '-') {
                    lower.put(key, cur - 1);
                }
            }
        }

        // 사다리 채우기
        char[] ans = new char[K - 1];
        Arrays.fill(ans, '*');
        for(char c : up) {
            int ui = upper.get(c), li = lower.get(c);
            int diff = Math.abs(ui - li);

            if(diff == 1) {
                ans[Math.min(ui, li)] = '-';
            }
            if(diff > 1) {
                System.out.println("x".repeat(K - 1));
                return;
            }
        }

        // 완성한 사다리로 비교
        for(char key : up) {
            int cur = upper.get(key);
            if(cur < K - 1 && ans[cur] == '-') {
                cur++;
            } else if(cur > 0 && ans[cur - 1] == '-') {
                cur--;
            }
            if(cur != lower.get(key)) {
                System.out.println("x".repeat(K - 1));
                return;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < K - 1; i++) sb.append(ans[i]);
        System.out.println(sb);
    }
}
