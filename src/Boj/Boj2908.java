package Boj;

import java.util.Scanner;

public class Boj2908 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");

        StringBuilder sb = new StringBuilder();
        int num1 = Integer.parseInt(sb.append(s[0]).reverse().toString());
        sb.setLength(0);
        int num2 = Integer.parseInt(sb.append(s[1]).reverse().toString());

        int max = Math.max(num1, num2);
        System.out.println(max);
    }

}
