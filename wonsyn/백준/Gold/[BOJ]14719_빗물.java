import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] block = new int[W];
        for(int i = 0; i < W; i++) {
            block[i] = Integer.parseInt(st.nextToken());
        }

        int ans = 0;
        for(int w = 1; w < W - 1; w++) {
            int left = -1, right = -1;
            for(int l = 0; l < w; l++) {
                left = Math.max(left, block[l]);
            }
            for(int r = w + 1; r < W; r++) {
                right = Math.max(right, block[r]);
            }

            if(left > block[w] && right > block[w])
                ans += Math.min(left, right) - block[w];
        }

        System.out.println(ans);
        br.close();
    }
}
