import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][M];
        for(int i = 0; i < N; i++) {
            String s = br.readLine();
            for(int j = 0; j < M; j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }

        int max = 0;
        for(int x = 0; x < N; x++) {
            for(int y = 0; y < M; y++) {
                int size = max;
                while(x + size < N && y + size < M) {
                    if (arr[x][y] == arr[x + size][y]
                            && arr[x][y] == arr[x][y + size]
                            && arr[x][y] == arr[x + size][y + size]){
                        max = size;
                    }
                    size++;
                }
            }
        }

        System.out.println((max + 1) * (max + 1));
        br.close();
    }
}
