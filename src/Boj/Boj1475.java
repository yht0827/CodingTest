package Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj1475 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String[] split = br.readLine().split("");
        int[] arr = new int[10];
        for (String s : split) {
            int num = Integer.parseInt(s);
            if (num == 6) {
                arr[9]++;
            } else {
                arr[num]++;
            }
        }

        arr[9] = arr[9] / 2 + arr[9] % 2;
        int result = 0;
        for (int j : arr) result = Math.max(result, j);

        System.out.println(result);
    }
}
