import java.util.*;

public class DragonArmy {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int defaultHealth = 250;
        int defaultArmor = 10;
        int defaultDamage = 45;
        int n = Integer.valueOf(scan.nextLine());
        Map<String, double[]> dragonType = new HashMap<>();
        Map<String, TreeMap<String, int[]>> dragons = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] input = scan.nextLine().split("\\s+");
            String type = input[0];
            String dragon = input[1];
            int damage = input[2].equals("null") ? defaultDamage : Integer.valueOf(input[2]);
            int health = input[3].equals("null") ? defaultHealth : Integer.valueOf(input[3]);
            int armor = input[4].equals("null") ? defaultArmor : Integer.valueOf(input[4]);

            if (!dragons.containsKey(type)) {
                dragons.put(type, new TreeMap<>());
                dragonType.put(type, new double[3]);
            }
            if (dragons.get(type).containsKey(dragon)) {
                int[] stats = dragons.get(type).get(dragon);
                dragonType.get(type)[0] -= stats[0];
                dragonType.get(type)[1] -= stats[1];
                dragonType.get(type)[2] -= stats[2];
            }
            if (!dragons.get(type).containsKey(dragon)) {
                dragons.get(type).put(dragon, new int[3]);
            }
            dragons.get(type).get(dragon)[0] = damage;
            dragons.get(type).get(dragon)[1] = health;
            dragons.get(type).get(dragon)[2] = armor;

            dragonType.get(type)[0] += damage;
            dragonType.get(type)[1] += health;
            dragonType.get(type)[2] += armor;
        }

        for (Map.Entry<String, TreeMap<String, int[]>> type : dragons.entrySet()) {
            System.out.printf("%s::(%.2f/%.2f/%.2f)\n", type.getKey(),
                    dragonType.get(type.getKey())[0] / type.getValue().size(),
                    dragonType.get(type.getKey())[1] / type.getValue().size(), 
                    dragonType.get(type.getKey())[2] / type.getValue().size());
            for (Map.Entry<String,int[]> dragon : type.getValue().entrySet()) {
                System.out.printf("-%s -> damage: %d, health: %d, armor: %d\n", dragon.getKey(),
                        dragon.getValue()[0], dragon.getValue()[1], dragon.getValue()[2]);
            }
        }
    }
}