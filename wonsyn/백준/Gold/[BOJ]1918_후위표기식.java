import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String pre = br.readLine();
        Stack<Character> op = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < pre.length(); i++) {
            char cur = pre.charAt(i);

            if('A' <= cur && cur <= 'Z') {  // 숫자 -> 바로 출력
                sb.append(cur);
            } else if(cur == '(') { // 여는 괄호 -> 연산자 스택에 push
                op.push(cur);
            } else if(cur == ')') { // 닫는 괄호 -> 연산자 스택에서 여는 괄호가 나올때까지 다 pop -> 출력
                while(!op.isEmpty() && op.peek() != '(') {
                    sb.append(op.pop());
                }
                op.pop();   // 처리된 여는 괄호 pop
            } else {    // 사칙연산자 -> 우선순위를 체크하는 check 메소드에서 확인 -> 연산자 스택에서 더 높은 우선순위, 먼저 해결할 연산자가 존재하는 동안 pop, 출력
                while(!op.isEmpty() && check(op.peek()) >= check(cur)) {
                    sb.append(op.pop());
                }
                op.push(cur);   // 현재 연산자는 push
            }
        }

        while(!op.isEmpty()) {  // 연산자 스택에 남아있는 모든 연산자 출력
            sb.append(op.pop());
        }

        System.out.println(sb);
        br.close();
    }

    public static int check(char op) {  // 사칙연산자간에 우선순위는 '*', '/'가  '+', '-"보다 높으므로 각각 2, 1로 설정. 괄호는 괄호끼리 처리하기 위해 가장 낮은 우선순위 부여 -> 사칙연산자가 들어왔을 떄 처리되지 않게 하기 위해
        if(op == '*' || op == '/') return 2;
        else if(op == '+' || op == '-') return 1;
        else return 0;
    }
}
