import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        next:
        for(int tc = 0; tc < T; tc++) {
            String command = br.readLine();
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine(), "[,]");

            int[] arr = new int[N];
            for(int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            int l = 0;
            int r = N - 1;
            boolean f = false;

            for(int i = 0; i < command.length(); i++) {
                char c = command.charAt(i);

                if (c == 'R') {
                    f = !f;
                } else {
                    if (l > r) {
                        sb.append("error\n");
                        continue next;
                    } else {
                        if (f) r--;
                        else l++;
                    }
                }
            }

            sb.append("[");
            if(f) {
                for(int i = r; i >= l; i--) {
                    sb.append(arr[i]).append(",");
                }
            } else {
                for(int i = l; i <= r; i++) {
                    sb.append(arr[i]).append(",");
                }
            }

            if(l <= r) sb.setLength(sb.length() - 1);
            sb.append("]\n");
        }

        System.out.println(sb);
        br.close();
    }
}
