package bj_1748_수이어쓰기1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int cnt = 0;
        for(int i = 1; i <= N; i++) {
            if(i < 10) cnt += 1;
            else if(i < 100) cnt += 2;
            else if(i < 1000) cnt += 3;
            else if(i < 10000) cnt += 4;
            else if(i < 100000) cnt += 5;
            else if(i < 1000000) cnt += 6;
            else if(i < 10000000) cnt += 7;
            else if(i < 100000000) cnt += 8;
            else cnt += 9;
        }

        System.out.println(cnt);
        br.close();
    }
}
