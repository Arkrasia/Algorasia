import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            int score = Integer.parseInt(st.nextToken());

            map.put(s, score);
            list.add(score);
        }

        int min = 0, max = 0;
        for(int i = 0; i < K; i++) {
            String s = br.readLine();
            int score = map.get(s);
            min += score; max += score;
            list.remove((Integer) score);
        }
        Collections.sort(list);
        int idx = 0;
        for(int i = 0; i < M - K; i++) {
            max += list.get(list.size() - idx - 1);
            min += list.get(idx++);
        }

        System.out.println(min + " " + max);
        br.close();
    }
}
