import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int J = Integer.parseInt(br.readLine());

        int start = 1, end = M;
        int move = 0;
        for(int j = 0; j < J; j++) {
            int drop = Integer.parseInt(br.readLine());
            if(start > drop) {
                end -= start - drop;
                move += start - drop;
                start = drop;
            } else if(end < drop) {
                start += drop - end;
                move += drop - end;
                end = drop;
            }
        }

        System.out.println(move);
        br.close();
    }
}
