package bj_1920_수찾기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arrN = new int[N];
        for(int i = 0; i < N; i++) {
            arrN[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] arrM = new int[M];
        for(int i = 0; i < M; i++) {
            arrM[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arrN);
        for(int m : arrM) {
            int start = 0, end = N - 1;
            boolean flag = false;
            while(start < end) {
                int mid = (start + end) / 2;

                if (m > arrN[mid]) {
                    start = mid + 1;
                } else {
                    end = mid;
                }
            }

            sb.append(arrN[end] == m ? 1 : 0).append("\n");
        }
        System.out.print(sb);
        br.close();
    }
}