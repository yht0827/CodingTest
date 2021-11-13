package Boj;

import java.util.Scanner;

public class Boj2675 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        sc.nextLine();
        for (int i = 0; i < T; i++) {
            String[] s = sc.nextLine().split(" ");

            int num = Integer.parseInt(s[0]);
            String str = s[1];
            for (int j = 0; j < str.length(); j++) {
                sb.append(String.valueOf(str.charAt(j)).repeat(Math.max(0, num)));
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
