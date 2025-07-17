import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        br.close();

        StringBuilder sb = new StringBuilder();
        sb.append("*".repeat(N))
                .append(" ".repeat((N - 1) * 2 - 1))
                .append("*".repeat(N)).append("\n");

        for(int i = 1; i < N - 1; i++) {
            sb.append(" ".repeat(i)).append("*").append(" ".repeat(N - 2)).append("*");
            sb.append(" ".repeat((N - i - 1) * 2 - 1)).append("*").append(" ".repeat(N - 2)).append("*");
            sb.append("\n");
        }

        sb.append(" ".repeat(N - 1))
                .append("*")
                .append(" ".repeat(N - 2))
                .append("*")
                .append(" ".repeat(N - 2))
                .append("*")
                .append("\n");

        for(int i = N - 2; i > 0; i--) {
            sb.append(" ".repeat(i)).append("*").append(" ".repeat(N - 2)).append("*");
            sb.append(" ".repeat((N - i - 1) * 2 - 1)).append("*").append(" ".repeat(N - 2)).append("*");
            sb.append("\n");
        }

        sb.append("*".repeat(N))
                .append(" ".repeat((N - 1) * 2 - 1))
                .append("*".repeat(N));

        System.out.println(sb);
    }
}