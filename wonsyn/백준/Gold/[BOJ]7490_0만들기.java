import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static char[] op = {' ', '+', '-'};
    static char[] selected;
    static int number;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++) {
            number = Integer.parseInt(br.readLine());

            selected = new char[number - 1];

            select(0);

            sb.append("\n");
        }

        System.out.println(sb);
        br.close();
    }

    static void select(int cnt) {
        if(cnt == number - 1) {
            StringBuilder s = new StringBuilder();
            s.append(1);
            for(int i = 2; i <= number; i++) {
                s.append(selected[i - 2]).append(i);
            }
            String str = s.toString().replaceAll(" ", "");
            StringTokenizer nums = new StringTokenizer(str, "+-");
            StringTokenizer ops = new StringTokenizer(str, "0123456789");

            int res = 0;
            res += Integer.parseInt(nums.nextToken());
            while(ops.hasMoreTokens()) {
                char o = ops.nextToken().charAt(0);
                if(o == '+') {
                    res += Integer.parseInt(nums.nextToken());
                } else {
                    res -= Integer.parseInt(nums.nextToken());
                }
            }

            if(res == 0) {
                sb.append(1);
                for(int i = 2; i <= number; i++) {
                    sb.append(selected[i - 2]).append(i);
                }
                sb.append("\n");
            }
            return;
        }

        for(int i = 0; i < 3; i++) {
            selected[cnt] = op[i];
            select(cnt + 1);
        }
    }
}
