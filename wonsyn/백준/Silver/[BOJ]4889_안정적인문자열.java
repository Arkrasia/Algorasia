import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int seq = 1;
        while(true) {
            String s = br.readLine();
            if(s.charAt(0) == '-') break;

            sb.append(seq).append(". ");

            Stack<Character> stack = new Stack<>();

            int cnt = 0;
            for(int i = 0; i < s.length(); i++) {
                if(s.charAt(i) == '{') stack.push('{');
                else if(!stack.isEmpty()) stack.pop();
                else {
                    stack.push('{');
                    cnt++;
                }
            }

            sb.append(cnt + stack.size() / 2).append("\n");
            seq++;
        }

        System.out.println(sb);
        br.close();
    }
}
