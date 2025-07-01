package bj_1235_학생번호;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int ans = -1;
        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];
        for(int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }

        int length = arr[0].length();
        Set<String> set = new HashSet<>();
        for(int k = 1; length - k >= 0; k++) {
            set.clear();
            for(String s : arr) {
                set.add(s.substring(length - k, length));
            }

            if(set.size() == N) {
                ans = k;
                break;
            }
        }

        System.out.println(ans);
        br.close();
    }
}
