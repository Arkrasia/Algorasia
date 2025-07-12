import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s1 = br.readLine();
        String s2 = br.readLine();

        boolean front = false;

        while(s1.length() != s2.length()) {
            int idx = front ? 0 : s2.length() - 1;
            char c = s2.charAt(idx);

            s2 = front ? s2.substring(1) : s2.substring(0, idx);
            if(c == 'B') front = !front;
        }

        if(front) s2 = new StringBuffer(s2).reverse().toString();
        System.out.println(s1.equals(s2) ? 1 : 0);
        br.close();
    }
}
