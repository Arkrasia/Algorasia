package bj_1091_카드섞기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, cur, next;
    static int[][] P;
    static int[] S, start;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        P = new int[2][N];
        S = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            P[0][i] = Integer.parseInt(st.nextToken());
        }
        start = P[0].clone();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            S[i] = Integer.parseInt(st.nextToken());
        }
        br.close();

        cur = 0;
        next = 1;
        int cnt = 0;
        while(!check()) {
            for(int i = 0; i < N; i++) {
                P[next][S[i]] = P[cur][i];
            }

            swap();
            if(cycle()) {
                cnt = -1;
                break;
            }

            cnt++;
        }

        System.out.println(cnt);
    }

    static void swap() {
        int temp = cur;
        cur = next; next = temp;
    }

    static boolean check() {
        for(int i = 0; i < N; i++) {
            if(P[cur][i] != i % 3) return false;
        }
        return true;
    }

    static boolean cycle() {
        for(int i = 0; i < N; i++) {
            if(P[cur][i] != start[i]) return false;
        }

        return true;
    }
}
