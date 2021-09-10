package Programmers;

import java.util.ArrayList;
import java.util.List;

public class 모음사전 {

    public static void main(String[] args) {

        String word = "AAAAE";
        System.out.println(solution(word));
    }

    static List<String> list = new ArrayList<>();

    public static int solution(String word) {

        backTrack("", 0);

        return list.indexOf(word);
    }

    public static void backTrack(String str, int len) {
        if (len > 5) return;
        list.add(str); // l

        for (int i = 0; i < 5; i++) {
            backTrack(str + "AEIOU".charAt(i), len + 1);
        }

    }

}
