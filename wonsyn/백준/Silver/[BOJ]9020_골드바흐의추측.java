package bj_9020_골드바흐의추측;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        boolean[] arr = new boolean[10001];
        for(int i = 2; i < 10001; i++) {
            if(!arr[i]) {
                for (int j = 2; i * j < 10001; j++) {
                    arr[i * j] = true;
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int tc = 0; tc < T; tc++) {
            int n = Integer.parseInt(br.readLine());

            int n1 = n / 2, n2 = n / 2;

            while(n1 + n2 != n || arr[n1] || arr[n2]) {
                n1--; n2++;
            }
            sb.append(n1).append(" ").append(n2).append("\n");
        }

        System.out.println(sb);
    }
}
