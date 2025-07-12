import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s1 = br.readLine();
        String s2 = br.readLine();

        while(s1.length() != s2.length()) {
            if(s2.charAt(s2.length() - 1) == 'A') {
                s2 = s2.substring(0, s2.length() - 1);
            } else {
                StringBuffer sb = new StringBuffer(s2.substring(0, s2.length() - 1)).reverse();
                s2 = sb.toString();
            }
        }

        System.out.println(s1.equals(s2) ? 1 : 0);
        br.close();
    }
}
