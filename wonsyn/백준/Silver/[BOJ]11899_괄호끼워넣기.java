import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        Stack<Character> stack = new Stack<>();

        int cnt = 0;
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '(') {
                stack.push('(');
            } else {
                if(stack.isEmpty()) {
                    cnt++;
                } else {
                    stack.pop();
                }
            }
        }

        cnt += stack.size();
        System.out.println(cnt);

        br.close();
    }
}
