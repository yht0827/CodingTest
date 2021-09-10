package Programmers;

import java.util.ArrayList;
import java.util.List;

public class 직업군_추천하기 {

    public static void main(String[] args) {
        String[] table = {"SI JAVA JAVASCRIPT SQL PYTHON C#", "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++",
                "HARDWARE C C++ PYTHON JAVA JAVASCRIPT", "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP", "GAME C++ C# JAVASCRIPT C JAVA"};
        String[] lang = {"PYTHON", "C++", "SQL"};
        int[] pre = {7, 5, 5};
        System.out.println(solution(table, lang, pre));
    }

    public static String solution(String[] table, String[] languages, int[] preference) {
        String answer = "";
        int result = -1;

        for (String s : table) {
            String[] split = s.split(" ");
            List<Lang> list = new ArrayList<>();
            for (int i = 1; i < split.length; i++) {
                list.add(new Lang(split[0], split[i], 6 - i));
            }

            int sum = 0;
            for (Lang lang : list) {
                for (int i = 0; i < languages.length; i++) {
                    int score;
                    if (lang.lang.equals(languages[i])) {
                        score = lang.score;
                        sum += score * preference[i];
                    }
                }
            }
            if (sum > result) {
                result = sum;
                answer = split[0];
            } else if (sum == result) {
                if (answer.charAt(0) - split[0].charAt(0) > 0) {
                    answer = split[0];
                }
            }
        }
        return answer;
    }

    static class Lang {
        String job;
        String lang;
        int score;

        public Lang(String job, String lang, int score) {
            this.job = job;
            this.lang = lang;
            this.score = score;
        }
    }
}
