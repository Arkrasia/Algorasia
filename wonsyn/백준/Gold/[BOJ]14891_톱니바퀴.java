import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean[][] wheels = new boolean[4][8];

        for(int i = 0; i < 4; i++) {
            String s = br.readLine();
            for(int j = 0; j < 8; j++) {
                wheels[i][j] = s.charAt(j) == '1';
            }
        }
        // 0, 2, 6
        int R = Integer.parseInt(br.readLine());

        for(int r = 0; r < R; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken()) - 1;
            int d = Integer.parseInt(st.nextToken());

            int[] spin = new int[4];
            spin[w] = d;
            for(int i = w - 1; i >= 0; i--) {
                if(wheels[i][2] != wheels[i + 1][6]) {
                    spin[i] = spin[i + 1] == 1 ? -1 : 1;
                } else break;
            }

            for(int i = w + 1; i < 4; i++) {
                if(wheels[i][6] != wheels[i - 1][2]) {
                    spin[i] = spin[i - 1] == 1 ? -1 : 1;
                } else break;
            }

            for(int i = 0; i < 4; i++) {
                rotate(wheels[i], spin[i]);
            }
        }

        int score = 0;
        for(int i = 0; i < 4; i++) {
            if(wheels[i][0]) score += Math.pow(2, i);
        }
        System.out.println(score);
        br.close();
    }

    public static void rotate(boolean[] wheel, int dir) {
        if(dir == 0) return;

        if(dir == -1) {
            boolean temp = wheel[0];
            for(int i = 0; i < 7; i++) wheel[i] = wheel[i + 1];
            wheel[7] = temp;
        } else {
            boolean temp = wheel[7];
            for(int i = 7; i > 0; i--) wheel[i] = wheel[i - 1];
            wheel[0] = temp;
        }
    }
}
