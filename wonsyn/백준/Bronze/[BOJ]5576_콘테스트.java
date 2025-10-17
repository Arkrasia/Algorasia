import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr1 = new int[10];
        int[] arr2 = new int[10];

        for(int i = 0; i < 10; i++) {
            arr1[i] = Integer.parseInt(br.readLine());
        }
        for(int i = 0; i < 10; i++) {
            arr2[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int sum1 = arr1[9] + arr1[8] + arr1[7];
        int sum2 = arr2[9] + arr2[8] + arr2[7];

        System.out.println(sum1 + " " + sum2);

        br.close();
    }
}
