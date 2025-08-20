import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Set<String> set = new HashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        set.add(st.nextToken());
        set.add(st.nextToken());
        st = new StringTokenizer(br.readLine());
        set.add(st.nextToken());
        set.add(st.nextToken());

        List<String> list = new ArrayList<>();
        for(String s1 : set) {
            for(String s2 : set) {
                list.add(s1 + " " + s2);
            }
        }
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        for(String s : list) {
            sb.append(s).append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}
