package Programmers;

import java.util.ArrayList;
import java.util.List;

public class 뉴스_클러스트링 {

    public static void main(String[] args) {
        String str1 = "FRANCE";
        String str2 = "french";
        System.out.println(solution(str1, str2));
    }

    public static int solution(String str1, String str2) {
        int len1 = str1.length() - 1;
        int len2 = str2.length() - 1;
        List<String> list1 = splitStr(len1, str1.toLowerCase());
        List<String> list2 = splitStr(len2, str2.toLowerCase());
        List<String> gyo = new ArrayList<>();
        List<String> hap = new ArrayList<>();

        // 합집합 교집합 처리 -> 교집합인 경우 list2 원소 제거
        for (String s : list1) {
            if (list2.remove(s)) {
                gyo.add(s);
            }
            hap.add(s);
        }

        hap.addAll(list2);

        double j;

        // 공집합 처리
        if (hap.size() == 0) {
            j = 1;
        } else {
            j = (double) gyo.size() / (double) hap.size();
        }

        return (int) (j * 65536);
    }

    public static List<String> splitStr(int len1, String str1) {
        List<String> list = new ArrayList<>();

        for (int i = 0; i < len1; i++) {
            char ch1 = str1.charAt(i);
            char ch2 = str1.charAt(i + 1);
            if (ch1 >= 'a' && ch1 <= 'z' && ch2 >= 'a' && ch2 <= 'z') {
                list.add(ch1 + "" + ch2);
            }
        }
        return list;
    }
}
