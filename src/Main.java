import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {


    }

    public static int test(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            Integer i1 = map.get(arr[i]);
            if (i1 != null) {
                map.put(arr[i], ++i1);
            } else {
                map.put(arr[i], 1);
            }
        }
        for (Integer i : map.keySet()) {
            Integer i1 = map.get(i);
            if (null != i1 && i1 > 1) {
                return i;
            }
        }
        return -1;
    }



    public static int maxDamage(List<Skill> skillList, int currentMana) {
        Map<Integer, Skill> costMap = new HashMap<>();
        int[] cost = new int[skillList.size()];
        for (Skill skill : skillList) {
            costMap.put(skill.getManaCost(), skill);
        }

        return -1;
    }




    static class Skill {
        private int manaCost;
        private int damage;

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

}
