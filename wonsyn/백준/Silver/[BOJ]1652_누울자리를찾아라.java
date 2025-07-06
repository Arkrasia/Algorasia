import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        boolean[][] room = new boolean[N][N];

        for(int i = 0; i < N; i++) {
            String s = br.readLine();
            for(int j = 0; j < N; j++) {
                room[i][j] = s.charAt(j) == '.';
            }
        }

        int row = 0;
        for(int r = 0; r < N; r++) {
            int cnt = 0;
            for(int c = 0; c < N; c++) {
                if(room[r][c]) cnt++;
                else {
                    if(cnt >= 2) row++;
                    cnt = 0;
                }
            }
            if(cnt >= 2) row++;
        }

        int col = 0;
        for(int c = 0; c < N; c++) {
            int cnt = 0;
            for(int r = 0; r < N; r++) {
                if(room[r][c]) cnt++;
                else {
                    if(cnt >= 2) col++;
                    cnt = 0;
                }
            }
            if(cnt >= 2) col++;
        }

        System.out.println(row + " " + col);
        br.close();
    }
}
