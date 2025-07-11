import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        if(N == 1) {
            System.out.println(-1);
            return;
        }
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();

        arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int i = arr.length - 1;
        while(arr[i] > arr[i - 1]) {
            i--;
            if(i == 0) {
                System.out.println(-1);
                return;
            }
        }

        i--;
        int j = arr.length - 1;
        while(arr[i] < arr[j]) {
            j--;
        }

        swap(i, j);
        i++; j = arr.length - 1;
        while(i < j) {
            swap(i++, j--);
        }

        StringBuilder sb = new StringBuilder();
        for(int k = 0; k < N; k++) {
            sb.append(arr[k]).append(" ");
        }
        System.out.println(sb);
    }

    static void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
