import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        char[][] puzzle = new char[R][C];
        for(int r = 0; r < R; r++) {
            String s = br.readLine();
            for(int c = 0; c < C; c++) {
                puzzle[r][c] = s.charAt(c);
            }
        }

        ArrayList<String> list = new ArrayList<>();

        for(int r = 0; r < R; r++) {
            StringBuilder temp = new StringBuilder();
            for(int c = 0; c < C; c++) {
                if(puzzle[r][c] != '#') {
                    temp.append(puzzle[r][c]);
                } else {
                    if(temp.length() > 1) {
                        list.add(temp.toString());
                    }
                    temp = new StringBuilder();
                }
            }
            if(temp.length() > 1) {
                list.add(temp.toString());
            }
        }

        for(int c = 0; c < C; c++) {
            StringBuilder temp = new StringBuilder();
            for(int r = 0; r < R; r++) {
                if(puzzle[r][c] != '#') {
                    temp.append(puzzle[r][c]);
                } else {
                    if(temp.length() > 1) {
                        list.add(temp.toString());
                    }
                    temp = new StringBuilder();
                }
            }
            if(temp.length() > 1) {
                list.add(temp.toString());
            }
        }

        Collections.sort(list);
        System.out.println(list.get(0));
        br.close();
    }
}
