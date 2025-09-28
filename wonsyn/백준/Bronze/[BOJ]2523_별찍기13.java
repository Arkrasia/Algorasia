import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= N; i++) {
            sb.append("*".repeat(i)).append("\n");
        }
        for(int i = N - 1; i > 0; i--) {
            sb.append("*".repeat(i)).append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}
