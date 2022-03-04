package Programmers;

import java.util.*;

public class 순위검색 {

    public static void main(String[] args) {
        String[] info = {"java backend junior pizza 150", "python frontend senior chicken 210", "python frontend senior chicken 150",
                "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100", "python and frontend and senior and chicken 200",
                "cpp and - and senior and pizza 250", "- and backend and senior and - 150", "- and - and - and chicken 100",
                "- and - and - and - 150"};
        System.out.println(solution(info, query));
    }

    static Map<String, List<Integer>> map = new HashMap<>();

    public static List<Integer> solution(String[] info, String[] query) {
        List<Integer> answer = new ArrayList<>();

        for (String s : info)
            dfs("", s.split(" "), 0);

        map.values().forEach(Collections::sort);

        for (String s : query) {
            String[] split = s.replaceAll(" and ", "").split(" ");
            String key = split[0];
            int value = Integer.parseInt(split[1]);
            answer.add(binarySearch(key, value));
        }

        return answer;
    }

    public static int binarySearch(String key, int value) {
        if (map.containsKey(key)) {
            List<Integer> list = map.get(key);
            int left = 0;
            int right = list.size() - 1;

            if (list.get(right) < value) {
                return 0;
            }

            while (left < right) {
                int mid = (left + right) / 2;
                if (list.get(mid) < value) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            return list.size() - left;
        }
        return 0;
    }

    public static void dfs(String s, String[] str, int depth) {
        if (depth == 4) {
            if (!map.containsKey(s)) {
                map.put(s, new ArrayList<>());
            }
            map.get(s).add(Integer.parseInt(str[depth]));
            return;
        }

        dfs(s + "-", str, depth + 1);
        dfs(s + str[depth], str, depth + 1);
    }
}
