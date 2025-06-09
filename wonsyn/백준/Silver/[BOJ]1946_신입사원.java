package bj_1946_신입사원;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int tc = 0; tc < T; tc++) {
            int N = Integer.parseInt(br.readLine());
            int[][] v = new int[N][2];

            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                v[i][0] = Integer.parseInt(st.nextToken());
                v[i][1] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(v, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if(o1[0] != o2[0]) {
                        return o1[0] - o2[0];
                    } else {
                        return o1[1] - o2[1];
                    }
                }
            });

            int cnt = 1;
            int top = 0;
            for(int i = 1; i < N; i++) {
                if(v[top][1] > v[i][1]) {
                    cnt++;
                    top = i;
                }
            }
            sb.append(cnt).append("\n");
        }

        System.out.print(sb);
        br.close();
    }
}
