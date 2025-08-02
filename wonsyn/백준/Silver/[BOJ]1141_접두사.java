import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[] arr = new String[N];
        for(int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }

        Arrays.sort(arr, (String s1, String s2) -> s2.length() - s1.length());
        Set<String> set = new HashSet<>();

        for(int i = 0; i < N; i++) {
            if(set.isEmpty()) {
                set.add(arr[i]);
                continue;
            }

            boolean flag = false;
            for(String s : set) {
                if(s.startsWith(arr[i])) {
                    flag = true;
                    break;
                }
            }

            if(!flag) set.add(arr[i]);
        }

        System.out.println(set.size());
        br.close();
    }
}
