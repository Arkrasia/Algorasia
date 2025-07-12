import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s1 = br.readLine();
        String s2 = br.readLine();

        boolean front = false;
        int f = 0, e = s2.length();

        while(s1.length() != e - f) {
            int idx = front ? f : e - 1;
            char c = s2.charAt(idx);
            if(front) f++;
            else e--;

            if(c == 'B') front = !front;
        }

        StringBuffer sb = new StringBuffer(s2.substring(f, e));
        if(front) sb.reverse();
        System.out.println(s1.equals(sb.toString()) ? 1 : 0);
        br.close();
    }
}
