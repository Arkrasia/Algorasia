import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] run = new int[N][2];
        int[][] trick = new int[N][5];
        int[] score = new int[N];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j = 0; j < 2; j++) {
                run[i][j] = Integer.parseInt(st.nextToken());
            }
            for(int j = 0; j < 5; j++) {
                trick[i][j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(run[i]);
            Arrays.sort(trick[i]);
            score[i] = run[i][1] + trick[i][4] + trick[i][3];
        }

        Arrays.sort(score);

        System.out.println(score[N - 1]);
        br.close();
    }
}
