import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            StringBuilder res = new StringBuilder();
            String s1 = st.nextToken();
            String s2 = st.nextToken();
            long res2 = Long.parseLong(s1) * Long.parseLong(s2);

            if (s1.length() < s2.length()) {
                String temp = s1;
                s1 = s2;
                s2 = temp;
            }

            int i = 1;
            while(i <= s2.length()) {
                int a = s1.charAt(s1.length() - i) - '0';
                int b = s2.charAt(s2.length() - i) - '0';

                res.insert(0, a * b);
                i++;
            }
            while(i <= s1.length()) {
                res.insert(0, s1.charAt(s1.length() - i));
                i++;
            }

            sb.append(Long.parseLong(res.toString()) == res2 ? 1 : 0).append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}
