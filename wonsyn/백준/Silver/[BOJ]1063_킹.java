import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] king, stone;
    static int[][] dir = {{}};
    // 아래 -> 위로, 가로 -> 인덱스 그대로(0-7), 세로 -> 인덱스 +1 (1-8)
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        king = new int[2]; stone = new int[2];
        StringTokenizer st = new StringTokenizer(br.readLine());
        String s = st.nextToken();
        king[1] = s.charAt(0) - 'A';
        king[0] = s.charAt(1) - '0';
        s = st.nextToken();
        stone[1] = s.charAt(0) - 'A';
        stone[0] = s.charAt(1) - '0';

        int N = Integer.parseInt(st.nextToken());
        for(int n = 0; n < N; n++) {
            String d = br.readLine();

            int[] nk = new int[2];
            nk[0] = king[0]; nk[1] = king[1];
            setDir(nk, d);
            if(nk[0] < 1 || nk[0] > 8 || nk[1] < 0 || nk[1] > 7) continue;

            if(nk[0] == stone[0] && nk[1] == stone[1]) {
                int[] ns = new int[2];
                ns[0] = stone[0]; ns[1] = stone[1];
                setDir(ns, d);
                if(ns[0] < 1 || ns[0] > 8 || ns[1] < 0 || ns[1] > 7) continue;
                stone[0] = ns[0]; stone[1] = ns[1];
            }

            king[0] = nk[0]; king[1] = nk[1];
        }

        StringBuilder sb = new StringBuilder();
        sb.append((char)(king[1] + 'A')).append(king[0]).append("\n")
                        .append((char)(stone[1] + 'A')).append(stone[0]);

        System.out.println(sb);
        br.close();
    }

    public static void setDir(int[] point, String d) {
        switch (d) {
            case "R":
                point[1]++; break;
            case "L":
                point[1]--; break;
            case "B":
                point[0]--; break;
            case "T":
                point[0]++; break;
            case "RT":
                point[1]++; point[0]++; break;
            case "LT":
                point[1]--; point[0]++; break;
            case "RB":
                point[1]++; point[0]--; break;
            case "LB":
                point[1]--; point[0]--; break;
        }
    }
}
