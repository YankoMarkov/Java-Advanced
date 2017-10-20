import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class DragonArmy {
	
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.valueOf(read.readLine());
		Map<String, double[]> dragonType = new HashMap<>();
		Map<String, Map<String, int[]>> dragons = new LinkedHashMap<>();
		
		int defaultHealth = 250;
		int defaultArmor = 10;
		int defaultDamage = 45;
		
		for (int i = 0; i < num; i++) {
			String[] inputs = read.readLine().split("\\s+");
			String type = inputs[0];
			String name = inputs[1];
			int damage = inputs[2].equals("null") ? defaultDamage : Integer.valueOf(inputs[2]);
			int health = inputs[3].equals("null") ? defaultHealth : Integer.valueOf(inputs[3]);
			int armor = inputs[4].equals("null") ? defaultArmor : Integer.valueOf(inputs[4]);
			
			if (!dragons.containsKey(type)) {
				dragons.put(type, new TreeMap<>());
				dragonType.put(type, new double[3]);
			}
			if (!dragons.get(type).containsKey(name)) {
				int[] res = {damage, health, armor};
				dragons.get(type).put(name, res);
			} else {
				dragonType.get(type)[0] -= dragons.get(type).get(name)[0];
				dragonType.get(type)[1] -= dragons.get(type).get(name)[1];
				dragonType.get(type)[2] -= dragons.get(type).get(name)[2];
				int[] res = {damage, health, armor};
				dragons.get(type).put(name, res);
			}
			dragonType.get(type)[0] += damage;
			dragonType.get(type)[1] += health;
			dragonType.get(type)[2] += armor;
		}
		for (Map.Entry<String, Map<String, int[]>> type : dragons.entrySet()) {
			double averageDamage = dragonType.get(type.getKey())[0] / type.getValue().size();
			double averagedHealth = dragonType.get(type.getKey())[1] / type.getValue().size();
			double averageArmor = dragonType.get(type.getKey())[2] / type.getValue().size();
			System.out.printf("%s::(%.2f/%.2f/%.2f)%n", type.getKey(), averageDamage, averagedHealth, averageArmor);
			for (Map.Entry<String, int[]> dragon : type.getValue().entrySet()) {
				int damage = dragon.getValue()[0];
				int health = dragon.getValue()[1];
				int armor = dragon.getValue()[2];
				System.out.printf("-%s -> damage: %d, health: %d, armor: %d%n", dragon.getKey(), damage, health, armor);
			}
		}
	}
}
