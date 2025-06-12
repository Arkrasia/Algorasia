import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] dir = {{}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N + 1][N + 1];
        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        ArrayList<Cloud> clouds = new ArrayList<>();
        clouds.add(new Cloud(N, 1));
        clouds.add(new Cloud(N, 2));
        clouds.add(new Cloud(N - 1, 1));
        clouds.add(new Cloud(N - 1, 2));

        for(int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            Set<Cloud> pre = new HashSet<>();
            while(!clouds.isEmpty()) {
                Cloud cloud = clouds.remove(0);
                cloud.x += dir[d][0] * s;
                cloud.y += dir[d][1] * s;
                while (cloud.x > N) cloud.x -= N;
                while (cloud.x < 1) cloud.x += N;
                while (cloud.y > N) cloud.y -= N;
                while (cloud.y < 1) cloud.y += N;

                pre.add(cloud);
            }

            for(Cloud cloud : pre) {
                map[cloud.x][cloud.y]++;
            }

            for(Cloud cloud : pre) {
                for(int d2 = 2; d2 < dir.length; d2 += 2) {
                    int x = cloud.x + dir[d2][0];
                    int y = cloud.y + dir[d2][1];
                    if (0 < x && x <= N && 0 < y && y <= N && map[x][y] > 0) {
                        map[cloud.x][cloud.y]++;
                    }
                }
            }

            for(int i = 1; i <= N; i++) {
                for(int j = 1; j <= N; j++) {
                    if(map[i][j] >= 2 && !pre.contains(new Cloud(i, j))) {
                        clouds.add(new Cloud(i, j));
                        map[i][j] -= 2;
                    }
                }
            }
        }

        int sum = 0;
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                sum += map[i][j];
            }
        }
        System.out.println(sum);
        br.close();
    }

    static class Cloud{
        int x, y;
        Cloud(int x, int y) {
            this.x = x; this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if(o == null || getClass() != o.getClass()) return false;
            Cloud c = (Cloud) o;
            return x == c.x && y == c.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
