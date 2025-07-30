import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] cnt = {3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String A = br.readLine(), B = br.readLine();
        Map<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < cnt.length; i++) map.put((char)('A' + i), cnt[i]);

        Queue<Integer> q = new ArrayDeque<>();
        for(int i = 0; i < A.length(); i++) {
            q.offer(map.get(A.charAt(i)));
            q.offer(map.get(B.charAt(i)));
        }

        while(q.size() > 2) {
            Queue<Integer> temp = new ArrayDeque<>();
            int a = q.poll();
            while(!q.isEmpty()) {
                int b = q.poll();

                temp.offer((a + b) % 10);
                a = b;
            }
            q = temp;
        }

        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()) sb.append(q.poll());
        System.out.println(sb);
        br.close();
    }
}
