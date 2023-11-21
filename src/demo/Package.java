package demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Bryce_dd 2023/9/15 20:15
 */
public class Package {

    public static List<Skill> getSkills() {
        Skill skill2 = new Skill(10, 10);
        Skill skill3 = new Skill(50, 51);
        Skill skill4 = new Skill(15, 20);
        List<Skill> skills = new ArrayList<>();
        skills.add(skill2);
        skills.add(skill3);
        skills.add(skill4);
        return skills;
    }

    public static void main(String[] args) {
        List<Skill> skills = getSkills();
//        Map<Integer, DamageObj> skill = getSkill(skills, 60);
//        System.out.println(maxDamage3(skill, 60, 0));
        System.out.println(maxDamage(skills, 60));
    }


    public static Map<Integer, DamageObj> getSkill(List<Skill> skills, int manaCost) {
        Map<Integer, DamageObj> map = new HashMap<>();
        for (Skill skill : skills) {
            DamageObj damageObj = new DamageObj((manaCost / skill.getManaCost()) * skill.getDamage(), skill.getDamage());
            map.put(skill.getManaCost(), damageObj);
        }
        return map;
    }

    public static int maxDamage3(Map<Integer, DamageObj> skillMap, int totalManaCost, int maxDamage) {
        int minCost = Integer.MAX_VALUE;
        for (Integer cost : skillMap.keySet()) {
            minCost = Math.min(cost, minCost);
        }
        if (minCost > totalManaCost) {
            return maxDamage;
        }

        int currentMaxDamage = -1;
        int currentSingleDamage = 0;
        int currentSingleCost = -1;
        for (Integer cost : skillMap.keySet()) {
            DamageObj obj = skillMap.get(cost);
            if (totalManaCost >= cost) {
                if (obj.getCountDamage() > currentMaxDamage) {
                    currentMaxDamage = obj.getCountDamage();
                    currentSingleDamage = obj.getSingleDamage();
                    currentSingleCost = cost;
                }
            }
        }
        return maxDamage3(skillMap, totalManaCost - currentSingleCost, maxDamage + currentSingleDamage);
    }

    public static int maxDamage2(List<Skill> skills, int totalManaCost, int maxDamage) {
        int minCost = Integer.MAX_VALUE;
        for (Skill skill : skills) {
            minCost = Math.min(minCost, skill.getManaCost());
        }

        if (minCost > totalManaCost) {
            return maxDamage;
        } else {
            int damage = -1;
            int cost = -1;
            Map<Integer, Integer> map = new HashMap<>();
            for (Skill skill : skills) {
                if (skill.getManaCost() > totalManaCost) {
                    continue;
                }
//                int count = totalManaCost / skill.getManaCost();
//                if (count * skill.getDamage() > damage) {
//                    damage = count * skill.getDamage();
//                    cost = skill.getManaCost() * count;
//                }
                if (skill.getDamage() > damage) {
                    damage = skill.getDamage();
                    cost = skill.manaCost;
                }

            }
            return maxDamage2(skills, totalManaCost - cost, maxDamage + damage);
        }
    }


    // cost = 60
    // 1: 20 20 2: 30 25 0 3: 50 50

    public static int maxDamage(List<Skill> skills, int totalManaCost) {
        int skillCount = skills.size();
        // dp[i][j] : 当使用第i个技能，魔法消耗值为j时，能产生的最大伤害
        // dp[i][j] = max(dp[i-1][j], dp[i-1][j - cost(i)] + damage(i))
        // dp[...][0]: 当魔法值为0时，最大伤害为0
        // dp[0][...]: 当不放技能时，最大伤害为0
        // 初始化边界条件: 边界值都为0，默认值为0，不再初始化
        int[][] dp = new int[skillCount + 1][totalManaCost + 1];
        for (int i = 1; i < skillCount + 1; i++) {
            for (int j = 1; j < totalManaCost + 1; j++) {
                if (j < cost(skills.get(i - 1))) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // 当前技能可用次数不做限制
                    int count = j / cost(skills.get(i - 1));
                    for (int k = 0; k < count + 1; k++) {
                        dp[i][j] = Math.max(
                                dp[i][j],
                                Math.max(dp[i - 1][j], dp[i - 1][j - k * cost(skills.get(i - 1))] + k * damage(skills.get(i - 1)))
                        );
//                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - cost(skills.get(i - 1))] + damage(skills.get(i - 1)));
                    }
                }
            }
        }
        return dp[skillCount][totalManaCost];
    }

    public static int cost(Skill skill) {
        return skill.getManaCost();
    }

    public static int damage(Skill skill) {
        return skill.getDamage();
    }

    public static class Skill {
        private int manaCost;
        private int damage;

        public Skill(int manaCost, int damage) {
            this.manaCost = manaCost;
            this.damage = damage;
        }

        public int getManaCost() {
            return manaCost;
        }

        public void setManaCost(int manaCost) {
            this.manaCost = manaCost;
        }

        public int getDamage() {
            return damage;
        }

        public void setDamage(int damage) {
            this.damage = damage;
        }
    }

    static class DamageObj {
        private int countDamage;
        private int singleDamage;

        public DamageObj(int countDamage, int singleDamage) {
            this.countDamage = countDamage;
            this.singleDamage = singleDamage;
        }



        public int getCountDamage() {
            return countDamage;
        }

        public void setCountDamage(int countDamage) {
            this.countDamage = countDamage;
        }

        public int getSingleDamage() {
            return singleDamage;
        }

        public void setSingleDamage(int singleDamage) {
            this.singleDamage = singleDamage;
        }
    }


}
