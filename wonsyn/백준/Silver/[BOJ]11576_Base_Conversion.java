import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        int dec = 0;
        for(int i = m - 1; i >= 0; i--) {
            int n = Integer.parseInt(st.nextToken());
            dec += n * (int)Math.pow(A, i);
        }
        while(dec > 0) {
            int mod = dec % B;
            sb.insert(0, " ").insert(0, mod);
            dec /= B;
        }

        System.out.println(sb);
        br.close();
    }
}
