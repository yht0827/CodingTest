package Boj;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Boj1157 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next().toLowerCase();
        int[] alpha = new int[26];

        for (int i = 0; i < str.length(); i++) alpha[str.charAt(i) - 'a']++;

        int max = 0;
        for (int i = 0; i < 26; i++) max = Math.max(max, alpha[i]);

        List<Character> list = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            if (max == alpha[i]) list.add((char) ('A' + i));
        }

        if (list.size() > 1) {
            System.out.println("?");
        } else {
            System.out.println(list.get(0));
        }
    }
}
