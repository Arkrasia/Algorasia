import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        int[] arr = new int[5];
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for(int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());

            for(int i = 0; i < 5; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);
            if(arr[3] - arr[1] >= 4) sb.append("KIN").append("\n");
            else sb.append(arr[1] + arr[2] + arr[3]).append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}
