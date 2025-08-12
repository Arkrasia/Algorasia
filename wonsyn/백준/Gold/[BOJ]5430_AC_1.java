import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        next:
        for(int tc = 0; tc < T; tc++) {
            String command = br.readLine();
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine(), "[,]");

            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < N; i++) {
                list.add(Integer.parseInt(st.nextToken()));
            }
            boolean f = false;

            for(int i = 0; i < command.length(); i++) {
                char c = command.charAt(i);

                if (c == 'R') {
                    f = !f;
                } else {
                    if (list.size() == 0) {
                        sb.append("error\n");
                        continue next;
                    } else {
                        if (f) list.remove(list.size() - 1);
                        else list.remove(0);
                    }
                }
            }

            sb.append("[");
            if(f) {
                for(int i = list.size() - 1; i >= 0; i--) {
                    sb.append(list.get(i)).append(",");
                }
            } else {
                for(int i = 0; i < list.size(); i++) {
                    sb.append(list.get(i)).append(",");
                }
            }

            if(list.size() != 0) sb.setLength(sb.length() - 1);
            sb.append("]\n");
        }

        System.out.println(sb);
        br.close();
    }
}
