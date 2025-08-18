import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int tc = 0; tc < T; tc++) {
            String s = br.readLine();

            String s2 = br.readLine();
            while(!s2.equals("what does the fox say?")) {
                StringTokenizer st = new StringTokenizer(s);
                StringTokenizer st2 = new StringTokenizer(s2);
                st2.nextToken();
                st2.nextToken();
                String c = st2.nextToken();

                StringBuilder sb2 = new StringBuilder();
                while(st.hasMoreTokens()) {
                    String temp = st.nextToken();
                    if(!temp.equals(c)) {
                        sb2.append(temp).append(" ");
                    }
                }

                s = sb2.toString();
                s2 = br.readLine();
            }
            sb.append(s).append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}
