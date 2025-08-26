import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] dices = new int[N][6];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 6; j++) {
                dices[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = Integer.MIN_VALUE;
        for(int s = 0; s < 6; s++) {
            int under = s;
            int upIdx = oppo(under);
            int upper = dices[0][upIdx];
            int max = findMax(dices[0], under, upIdx);

            for(int i = 1; i < N; i++) {
                int[] dice = dices[i];

                under = find(dice, upper);
                upIdx = oppo(under);
                upper = dice[upIdx];
                max += findMax(dice, under, upIdx);
            }

            ans = Math.max(max, ans);
        }

        System.out.println(ans);
        br.close();
    }

    public static int oppo(int n) {
        if(n == 0) return 5;
        else if(n == 1) return 3;
        else if(n == 2) return 4;
        else if(n == 3) return 1;
        else if(n == 4) return 2;
        else return 0;
    }

    public static int find(int[] dice, int n) {
        for(int i = 0; i < 6; i++) {
            if(dice[i] == n) return i;
        }
        return -1;
    }

    public static int findMax(int[] dice, int under, int upper) {
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < 6; i++) {
            if (i != under && i != upper) max = Math.max(max, dice[i]);
        }
        return max;
    }
}
