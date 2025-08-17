import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int tc = 0; tc < T; tc++) {
            br.readLine();
            StringTokenizer st = new StringTokenizer(br.readLine());
            StringBuffer s = new StringBuffer(st.nextToken());
            while(st.hasMoreTokens()) {
                char cur = st.nextToken().charAt(0);

                if(cur <= s.charAt(0)) {
                    s.insert(0, cur);
                } else {
                    s.append(cur);
                }
            }

            sb.append(s).append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}
