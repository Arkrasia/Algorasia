package bj_2608_로마숫자;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String n1 = br.readLine();
        String n2 = br.readLine();

        int sum = toArab(n1) + toArab(n2);
        System.out.println(sum);
        System.out.println(toRome(sum));

        br.close();
    }

    public static String toRome(int num) {
        StringBuilder sb = new StringBuilder();

        int temp = 1000;
        while(temp != 0) {
            int div = num / temp;
            char c = toRomeNum(temp);
            if(div < 4) {
                for (int d = 0; d < div; d++) sb.append(c);
            } else if(div == 4) {
                sb.append(c).append(toRomeNum(temp * 5));
            } else if (div < 9) {
                sb.append(toRomeNum(temp * 5));
                for (int d = 0; d < div - 5; d++) sb.append(c);
            } else if(div == 9) {
                sb.append(c).append(toRomeNum(temp * 10));
            }
            num %= temp;
            temp /= 10;
        }

        return sb.toString();
    }

    public static char toRomeNum(int n) {
        switch (n) {
            case 1:
                return 'I';
            case 5:
                return 'V';
            case 10:
                return 'X';
            case 50:
                return 'L';
            case 100:
                return 'C';
            case 500:
                return 'D';
            case 1000:
                return 'M';
            default:
                return 'x';
        }
    }

    public static int toArab(String s) {
        int sum = 0;

        for(int i = 0; i < s.length() - 1; i++) {
            if(toArabNum(s.charAt(i)) < toArabNum(s.charAt(i + 1))) {
                sum -= toArabNum(s.charAt(i));
            } else {
                sum += toArabNum(s.charAt(i));
            }
        }
        sum += toArabNum(s.charAt(s.length() - 1));

        return sum;
    }

    public static int toArabNum(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return -1;
        }
    }
}
