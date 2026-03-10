package bj_1431_시리얼번호;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[] arr = new String[N];

        for(int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }
        br.close();

        Arrays.sort(arr, (o1, o2) -> {
            if (o1.length() - o2.length() != 0) {
                return o1.length() - o2.length();
            } else {
                int sum1 = 0;
                int sum2 = 0;
                for (int i = 0; i < o1.length(); i++) {
                    if (o1.charAt(i) >= '0' && o1.charAt(i) <= '9') {
                        sum1 += o1.charAt(i) - '0';
                    }
                    if (o2.charAt(i) >= '0' && o2.charAt(i) <= '9') {
                        sum2 += o2.charAt(i) - '0';
                    }
                }
                if (sum1 != sum2) return sum1 - sum2;
                else return o1.compareTo(o2);
            }
        });

        for(int i = 0; i < N; i++) {
            System.out.println(arr[i]);
        }
    }
}
