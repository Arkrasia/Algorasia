package bj_17085_십자가2개놓기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, max = Integer.MIN_VALUE;
    static char[][] board;
    static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new char[N][M];
        for(int i = 0; i < N; i++) {
            String s = br.readLine();
            for(int j = 0; j < M; j++) {
                board[i][j] = s.charAt(j);
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(board[i][j] == '#') find(i, j);
            }
        }

        System.out.println(max);
        br.close();
    }

    public static class Cross {
        int r, c, l;

        Cross(int r, int c, int l) {
            this.r = r; this.c = c; this.l = l;
        }

        public void change() {
            for(int d = 0; d < 4; d++) {
                board[r + dir[d][0] * l][c + dir[d][1] * l] = '*';
            }
        }

        public void undo() {
            board[r][c] = '#';
            for(int len = 1; len <= l; len++) {
                for (int d = 0; d < 4; d++) {
                    board[r + dir[d][0] * len][c + dir[d][1] * len] = '#';
                }
            }
        }
    }

    public static void find(int r, int c) {
        Cross c1 = new Cross(r, c, 0);

        end:
        while(true) {
            for(int d = 0; d < 4; d++) {
                int nr = r + dir[d][0] * c1.l;
                int nc = c + dir[d][1] * c1.l;
                if(nr < 0 || N <= nr || nc < 0 || M <= nc || board[nr][nc] != '#') {
                    break end;
                }
            }

            c1.change();
            findNext(c1);
            c1.l++;
        }
        c1.l--;
        c1.undo();
    }

    public static void findNext(Cross c1) {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(board[i][j] != '#') continue;

                Cross c2 = new Cross(i, j, 0);

                end:
                while(true) {
                    for(int d = 0; d < 4; d++) {
                        int nr = i + dir[d][0] * c2.l;
                        int nc = j + dir[d][1] * c2.l;
                        if(nr < 0 || N <= nr || nc < 0 || M <= nc || board[nr][nc] != '#') {
                            break end;
                        }
                    }
                    c2.l++;
                }
                c2.l--;

                max = Math.max((c1.l * 4 + 1) * (c2.l * 4 + 1), max);
            }
        }
    }
}
