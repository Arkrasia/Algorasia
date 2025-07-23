import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();

        String[] arr = new String[N];
        for(int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }
        br.close();

        next:
        for(String s : arr) {
            if(set.isEmpty()) set.add(s);

            for(int i = 0; i < s.length(); i++) {
                if(set.contains(s)) {
                    continue next;
                } else {
                    char c = s.charAt(0);
                    s = s.substring(1) + c;
                }
            }
            set.add(s);
        }

        System.out.println(set.size());
    }
}
