package bj_1748_수이어쓰기1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        br.close();

        int N = Integer.parseInt(s);

        int cnt = 0;
        long low = 1, up = 9;
        int len = 1;

        while(low <= N) {
            if(up > N) up = N;

            cnt += len * (up - low + 1);
            low *= 10;
            up = 10 * up + 9;
            len++;
        }

        System.out.println(cnt);
    }
}
