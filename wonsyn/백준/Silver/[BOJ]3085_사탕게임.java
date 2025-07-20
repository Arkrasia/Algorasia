import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static char[][] board;
    static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        board = new char[N][N];
        for(int i = 0; i < N; i++) {
            String s = br.readLine();
            for(int j = 0; j < N; j++) {
                board[i][j] = s.charAt(j);
            }
        }
        if(check() == N) {
            System.out.println(N);
            return;
        }

        int max = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                for(int d = 0; d < 4; d++) {
                    int nr = i + dir[d][0];
                    int nc = j + dir[d][1];
                    if(0 <= nr && nr < N && 0 <= nc && nc < N && board[i][j] != board[nr][nc]) {
                        swap(i, j, nr, nc);
                        int cnt = check();
                        if(cnt == N) {
                            System.out.println(N);
                            return;
                        } else {
                            max = Math.max(max, cnt);
                        }
                        swap(i, j, nr, nc);
                    }
                }
            }
        }

        System.out.println(max);
        br.close();
    }

    static int check() {
        int max = 0;

        for(int i = 0; i < N; i++) {
            int cnt = 1;
            char cur = board[i][0];
            for(int j = 0; j < N - 1; j++) {
                if(board[i][j + 1] != cur) {
                    max = Math.max(max, cnt);
                    cnt = 1;
                    cur = board[i][j + 1];
                } else {
                    cnt++;
                    if(cnt == N) return N;
                }
            }
            max = Math.max(max, cnt);
        }

        for(int j = 0; j < N; j++) {
            int cnt = 1;
            char cur = board[0][j];
            for(int i = 0; i < N - 1; i++) {
                if(board[i + 1][j] != cur) {
                    max = Math.max(max, cnt);
                    cnt = 1;
                    cur = board[i + 1][j];
                } else {
                    cnt++;
                    if(cnt == N) return N;
                }
            }
            max = Math.max(max, cnt);
        }

        return max;
    }

    static void swap(int r1, int c1, int r2, int c2) {
        char temp = board[r1][c1];
        board[r1][c1] = board[r2][c2];
        board[r2][c2] = temp;
    }
}
