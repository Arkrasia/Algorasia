import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};    // 상 우 하 좌

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int number = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][N];
        int num = 1, size = 1, d = 0;
        int r = N / 2, c = N / 2;
        arr[r][c] = num;
        end: while(true) {
            for(int i = 0; i < 2; i++) {
                for (int j = 0; j < size; j++) {
                    r += dir[d][0];
                    c += dir[d][1];
                    arr[r][c] = ++num;
                    if(num == N * N) break end;
                }
                d = (d + 1) == 4 ? 0 : d + 1;
            }
            size++;
        }

        int ansR = -1, ansC = -1;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                sb.append(arr[i][j]).append(" ");
                if(arr[i][j] == number) {
                    ansR = i + 1;
                    ansC = j + 1;
                }
            }
            sb.append("\n");
        }
        sb.append(ansR).append(" ").append(ansC);
        System.out.println(sb);
        br.close();
    }
}
