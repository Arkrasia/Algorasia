package bj_1966_프린터큐;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int tc = 0; tc < T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            ArrayList<Integer> q = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) {
                q.add(Integer.parseInt(st.nextToken()));
            }

            int cnt = 0;
            while(M >= 0 && N > 0) {
                boolean flag = false;
                int n = q.get(0);
                for(int i = 1; i < N; i++) {
                    if(q.get(i) > n) {
                        q.add(q.remove(0));
                        if(M == 0) M += N - 1;
                        else M--;
                        flag = true;
                        break;
                    }
                }

                if(!flag) {
                    q.remove(0);
                    cnt++;
                    N--;
                    M--;
                }
            }
            sb.append(cnt).append("\n");
        }

        System.out.print(sb);
        br.close();
    }
}
