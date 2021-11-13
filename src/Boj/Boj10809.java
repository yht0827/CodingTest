package Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj10809 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] alpha = new int[26];

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        String str = st.nextToken();
        Arrays.fill(alpha, -1);

        for (int i = 0; i < str.length(); i++) {
            if (alpha[str.charAt(i) - 'a'] != -1) continue;
            alpha[str.charAt(i) - 'a'] = i;
        }

        for (int j : alpha) {
            System.out.print(j + " ");
        }
        System.out.println();
    }

}
