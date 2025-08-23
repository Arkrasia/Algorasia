import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        ArrayList<String> list = new ArrayList<>();
        int cnt = 0;
        for(int i = 0; i < N; i++) {
            list.add(br.readLine());
        }

        for(int i = 0; i < N; i++) {
            String out = br.readLine();

            int idx = list.indexOf(out);
            list.remove(out);
            if(idx != 0) cnt++;
        }

        System.out.println(cnt);
        br.close();
    }
}
