import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        StringBuilder sb  = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        boolean flag = false;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case '<':
                    while(!stack.isEmpty()) {
                        sb.append(stack.pop());
                    }
                    flag = true;
                    sb.append(c);
                    break;
                case '>':
                    flag = false;
                    sb.append(c);
                    break;
                case ' ':
                    while(!stack.isEmpty()) {
                        sb.append(stack.pop());
                    }
                    sb.append(' ');
                    break;
                default:
                    if(!flag) {
                        stack.push(c);
                    } else {
                        sb.append(c);
                    }
                    break;
            }
        }

        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        System.out.println(sb);
        br.close();
    }
}
