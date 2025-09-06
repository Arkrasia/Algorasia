import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        Map<Integer, int[]> map = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        int seq = 1;
        for(int i = 0; i < N; i++) {
            int n = Integer.parseInt(st.nextToken());
            if(map.get(n) == null) map.put(n, new int[]{1, seq++});
            else {
                int[] temp = map.get(n);
                temp[0]++;
                map.put(n, temp);
            }
        }
        PriorityQueue<Number> pq = new PriorityQueue<>(new Comparator<Number>() {
            @Override
            public int compare(Number o1, Number o2) {
                if(o1.cnt == o2.cnt)  return o1.seq - o2.seq;
                return o2.cnt - o1.cnt;
            }
        });

        Set<Integer> keyset = map.keySet();
        for(int i : keyset) {
            int[] cur = map.get(i);
            pq.offer(new Number(i, cur[0], cur[1]));
        }

        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()) {
            Number cur = pq.poll();

            for(int i = 0; i < cur.cnt; i++) {
                sb.append(cur.num).append(" ");
            }
        }

        System.out.println(sb);
        br.close();
    }

    public static class Number {
        int num, cnt, seq;

        Number(int num, int cnt, int seq) {
            this.num = num; this.cnt = cnt; this.seq = seq;
        }
    }
}
