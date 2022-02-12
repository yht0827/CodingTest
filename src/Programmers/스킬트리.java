package Programmers;

public class 스킬트리 {

    public static void main(String[] args) {
        String skill = "CBDK";
        String[] skill_trees = {"CB", "CXYB", "BD", "AECD", "ABC", "AEX", "CDB", "CBKD", "IJCB", "LMDK"};
        System.out.println(solution(skill, skill_trees));
    }

    public static int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for (String skill_tree : skill_trees) {
            String skillTemp = skill_tree;

            for (int i = 0; i < skill_tree.length(); i++) {
                String substring = skill_tree.substring(i, i + 1);

                if (!skill.contains(substring)) {
                    skillTemp = skillTemp.replace(substring, "");
                }
            }

            if (skill.indexOf(skillTemp) == 0) {
                answer++;
            }
        }
        return answer;
    }
}
