import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static final int WHITE = 0, RED = 1, BLUE = 2;
    static int[][] dir = {{}, {0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][N];
        ArrayList<Piece>[][] lists = new ArrayList[N][N];
        ArrayList<Piece> pieces = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                lists[i][j] = new ArrayList<>();
            }
        }

        for(int k = 0; k < K; k++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int d = Integer.parseInt(st.nextToken());

            Piece p = new Piece(r, c, d);
            lists[r][c].add(p);
            pieces.add(p);
        }

        int turn = 0;
        end: while(true) {
            turn++;

            if(turn > 1000) {
                turn = -1;
                break;
            }

            for(int pi = 0; pi < pieces.size(); pi++) {
                Piece p = pieces.get(pi);
                int r = p.r, c = p.c;
                int nr = r + dir[p.d][0];
                int nc = c + dir[p.d][1];
                int idx = lists[r][c].indexOf(p);

                if(nr < 0 || nr >= N || nc < 0 || nc >= N || map[nr][nc] == BLUE) {
                    p.change();
                    nr = r + dir[p.d][0];
                    nc = c + dir[p.d][1];
                    if(0 <= nr && nr < N && 0 <= nc && nc < N && map[nr][nc] != BLUE) {
                        pi--;
                    }
                } else if(map[nr][nc] == RED) {
                    while(idx < lists[r][c].size()) {
                        Piece temp = lists[r][c].remove(lists[r][c].size() - 1);
                        temp.r = nr; temp.c = nc;
                        lists[nr][nc].add(temp);
                    }
                } else if(map[nr][nc] == WHITE) {
                    while(idx < lists[r][c].size()) {
                        Piece temp = lists[r][c].remove(idx);
                        temp.r = nr; temp.c = nc;
                        lists[nr][nc].add(temp);
                    }
                }


                if(lists[p.r][p.c].size() >= 4) break end;
            }
        }

        System.out.println(turn);
        br.close();
    }

    static class Piece {
        int r, c, d;

        Piece(int r, int c, int d) {
            this.r = r; this.c = c; this.d = d;
        }

        public void change() {
            if(this.d == 1) this.d = 2;
            else if(this.d == 2) this.d = 1;
            else if(this.d == 3) this.d = 4;
            else if(this.d == 4) this.d = 3;
        }
    }
}
