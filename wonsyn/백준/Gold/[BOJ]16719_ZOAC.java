package bj_16719_ZOAC;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static StringBuilder sb;
    static String s;
    static boolean[] check;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        s = br.readLine();
        sb = new StringBuilder();
        check = new boolean[s.length()];

        zoac(0, s.length());

        System.out.println(sb);
        br.close();
    }

    public static void zoac(int start, int end) {
        if(start == end) {
            return;
        }

        int minIdx = start;
        for(int i = start + 1; i < end; i++) {
            if(s.charAt(i) < s.charAt(minIdx)) {
                minIdx = i;
            }
        }

        check[minIdx] = true;
        for(int i = 0; i < s.length(); i++) {
            if (check[i]) sb.append(s.charAt(i));
        }
        sb.append("\n");

        zoac(minIdx + 1, end);
        zoac(start, minIdx);
    }
}
