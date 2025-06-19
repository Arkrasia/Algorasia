import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        char d = st.nextToken().charAt(0);

        int cnt = 0;
        for(int num = 1; num <= n; num++) {
            String number = "" + num;

            for(int i = 0; i < number.length(); i++) {
                if(number.charAt(i) == d) cnt++;
            }
        }

        System.out.println(cnt);
        br.close();
    }
}
