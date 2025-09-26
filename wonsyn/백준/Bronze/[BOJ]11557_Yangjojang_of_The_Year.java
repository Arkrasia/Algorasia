import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int tc = 0; tc < T; tc++) {
            int N = Integer.parseInt(br.readLine());

            String s = "";
            int max = -1;
            StringTokenizer st;
            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                String temp = st.nextToken();
                int a = Integer.parseInt(st.nextToken());
                if(max < a) {
                    max = a; s = temp;
                }
            }

            sb.append(s).append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}
