import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        if(N == 0) {
            System.out.println(1);
            br.close();
            return;
        }
        int score = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int upper = 0;
        int same = 0;
        while(st.hasMoreTokens()) {
            int n = Integer.parseInt(st.nextToken());
            if(n > score) upper++;
            else if(n == score) same++;
        }

        if(upper + same >= P) {
            System.out.println(-1);
        } else {
            System.out.println(upper + 1);
        }

        br.close();
    }
}
