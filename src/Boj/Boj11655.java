package Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj11655 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static char[] s;

    public static void main(String[] args) throws IOException {
        s = br.readLine().toCharArray();
        int len = s.length;

        // A ~ Z 65 ~ 90
        // a ~ z 97 ~ 122
        for (int i = 0; i < len; i++) {
            if (s[i] >= 'A' && s[i] <= 'Z') {
                int num = (int) s[i] + 13;
                if (num > 90) {
                    s[i] = (char) ((num % 91) + 65);
                } else {
                    s[i] = (char) num;
                }
            } else if (s[i] >= 'a' && s[i] <= 'z') {
                int num = (int) s[i] + 13;
                if (num > 122) {
                    s[i] = (char) ((num % 123) + 97);
                } else {
                    s[i] = (char) num;
                }
            }
        }
        System.out.println(s);
    }

}
