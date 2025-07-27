import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        char[][] arr = new char[N][N];
        boolean flag = false;
        int[] heart = new int[2];
        for(int i = 0; i < N; i++) {
            String s = br.readLine();
            for(int j = 0; j < N; j++) {
                arr[i][j] = s.charAt(j);
                if(!flag && arr[i][j] == '*') {
                    flag = true;
                    heart[0] = i + 1; heart[1] = j;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(heart[0] + 1).append(" ").append(heart[1] + 1).append("\n");

        int leftArm = 0, rightArm = 0, waist = 0, leftLeg = 0, rightLeg = 0;
        int low;
        int nr = heart[0], nc = heart[1] - 1;
        while(check(nr, nc) && arr[nr][nc] == '*') {
            leftArm++;
            nc--;
        }
        nc = heart[1] + 1;
        while(check(nr, nc) && arr[nr][nc] == '*') {
            rightArm++;
            nc++;
        }
        nr = heart[0] + 1; nc = heart[1];
        while(check(nr, nc) && arr[nr][nc] == '*') {
            waist++;
            nr++;
        }
        low = nr;
        nc = heart[1] - 1;
        while(check(nr, nc) && arr[nr][nc] == '*') {
            leftLeg++;
            nr++;
        }
        nc = heart[1] + 1;
        nr = low;
        while(check(nr, nc) && arr[nr][nc] == '*') {
            rightLeg++;
            nr++;
        }

        sb.append(leftArm).append(" ").append(rightArm).append(" ").append(waist).append(" ").append(leftLeg).append(" ").append(rightLeg);
        System.out.println(sb);
        br.close();
    }

    public static boolean check(int r, int c) {
        return 0 <= r && r < N && 0 <= c && c < N;
    }
}
