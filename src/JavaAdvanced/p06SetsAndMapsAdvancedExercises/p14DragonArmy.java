package JavaAdvanced.p06SetsAndMapsAdvancedExercises;

import java.util.*;

public class p14DragonArmy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, List<Integer>>> dragons = new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0) {
            String[] input = scanner.nextLine().split("\\s+");
            String type = input[0];
            String name = input[1];
            String dmgT = input[2];
            String healthT = input[3];
            String armorT = input[4];
            int dmg, health, armor;
            if (dmgT.equals("null")) {
                dmg = 45;
            } else {
                dmg = Integer.parseInt(dmgT);
            }
            if (healthT.equals("null")) {
                health = 250;
            } else {
                health = Integer.parseInt(healthT);
            }
            if (armorT.equals("null")) {
                armor = 10;
            } else {
                armor = Integer.parseInt(armorT);
            }

            dragons.putIfAbsent(type, new TreeMap<>());
            dragons.get(type).put(name, Arrays.asList(dmg, health, armor));
//            dragons.get(type).putIfAbsent(name, new ArrayList<>());
//            dragons.get(type).get(name).add(dmg);
//            dragons.get(type).get(name).add(health);
//            dragons.get(type).get(name).add(armor);
        }

        for (Map.Entry<String, Map<String, List<Integer>>> entry : dragons.entrySet()) {
            double avgDmg = 0, avgHealth = 0, avgArmor = 0;
            Map<String, List<Integer>> temp = entry.getValue();
            for (Map.Entry<String, List<Integer>> secoundEntry : temp.entrySet()) {
                avgDmg += secoundEntry.getValue().get(0);
                avgHealth += secoundEntry.getValue().get(1);
                avgArmor += secoundEntry.getValue().get(2);
            }
            if (entry.getValue().size() == 0) {
                avgDmg = 0;
                avgArmor = 0;
                avgHealth = 0;
            } else {
                avgDmg /= entry.getValue().size();
                avgHealth /= entry.getValue().size();
                avgArmor /= entry.getValue().size();
            }
            System.out.printf("%s::(%.2f/%.2f/%.2f)%n", entry.getKey(), avgDmg, avgHealth, avgArmor);
            for (Map.Entry<String, List<Integer>> secondEntry : temp.entrySet()) {
                System.out.printf("-%s -> damage: %d, health: %d, armor: %d%n", secondEntry.getKey(), secondEntry.getValue().get(0), secondEntry.getValue().get(1), secondEntry.getValue().get(2));
            }

        }


    }
}
