import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;

        Stack<int[]> stack = new Stack<>();
        int score = 0;
        for(int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            int q = Integer.parseInt(st.nextToken());
            if(q == 1) {
                stack.push(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
            }
            if(!stack.isEmpty()) {
                int[] cur = stack.peek();
                cur[1]--;

                if(cur[1] == 0) {
                    score += cur[0];
                    stack.pop();
                }
            }
        }

        System.out.println(score);
        br.close();
    }
}
