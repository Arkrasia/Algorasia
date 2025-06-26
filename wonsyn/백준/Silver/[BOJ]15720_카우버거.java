import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> burgers = new PriorityQueue<>(Collections.reverseOrder());
        st = new StringTokenizer(br.readLine());
        for(int b = 0; b < B; b++) {
            burgers.offer(Integer.parseInt(st.nextToken()));
        }

        PriorityQueue<Integer> sides = new PriorityQueue<>(Collections.reverseOrder());
        st = new StringTokenizer(br.readLine());
        for(int c = 0; c < C; c++) {
            sides.offer(Integer.parseInt(st.nextToken()));
        }

        PriorityQueue<Integer> drink = new PriorityQueue<>(Collections.reverseOrder());
        st = new StringTokenizer(br.readLine());
        for(int d = 0; d < D; d++) {
            drink.offer(Integer.parseInt(st.nextToken()));
        }

        int total = 0;
        int discount = 0;
        while(!burgers.isEmpty() || !sides.isEmpty() || !drink.isEmpty()) {
            int b = -1, s = -1, d = -1;

            if(!burgers.isEmpty()) b = burgers.poll();
            if(!sides.isEmpty()) s = sides.poll();
            if(!drink.isEmpty()) d = drink.poll();

            if(b != -1 && s != -1 && d != -1) {
                int temp = b + s + d;
                total += temp;
                discount += temp * 0.9;
                continue;
            }

            if(b != -1) {
                total += b;
                discount += b;
            }
            if(s != -1) {
                total += s;
                discount += s;
            }
            if(d != -1) {
                total += d;
                discount += d;
            }
        }

        System.out.println(total);
        System.out.println(discount);
        br.close();
    }
}
