import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] ops = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            ops[i] = Integer.parseInt(st.nextToken());
        }

        ArrayDeque<Integer> dq = new ArrayDeque<>();
        for(int i = 1, j = N; j > 0; i++, j--) {
            int op = ops[j];

            switch (op) {
                case 1:
                    dq.offerFirst(i);
                    break;
                case 2:
                    int temp = dq.pollFirst();
                    dq.offerFirst(i);
                    dq.offerFirst(temp);
                    break;
                case 3:
                    dq.offerLast(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i : dq) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
        br.close();
    }
}
