import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 1; i <= N; i++) {
            list.add(i);
        }

        int cnt = 0;
        while(st.hasMoreTokens()) {
            int num = Integer.parseInt(st.nextToken());

            int idx = list.indexOf(num);
            int size = list.size();
            if(idx > size / 2) {
                size--;
                while(idx <= size) {
                    list.add(0, list.remove(list.size() - 1));
                    size--; cnt++;
                }
            } else {
                int front = 0;
                while (front < idx) {
                    list.add(list.remove(0));
                    front++; cnt++;
                }
            }
            list.remove(0);
        }

        System.out.println(cnt);
        br.close();
    }
}
