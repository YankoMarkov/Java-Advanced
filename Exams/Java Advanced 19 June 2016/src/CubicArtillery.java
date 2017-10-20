import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class CubicArtillery {
	
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		int capacity = Integer.valueOf(read.readLine());
		Deque<Integer> weapons = new ArrayDeque<>();
		Deque<String> bunkers = new ArrayDeque<>();
		
		int freeCapacity = capacity;
		String inputs = null;
		
		while (!(inputs = read.readLine()).equals("Bunker Revision")) {
			String[] input = inputs.split(" ");
			
			for (String str : input) {
				if (!Character.isDigit(str.charAt(0))) {
					bunkers.add(str);
				} else {
					int weaponCapacity = Integer.valueOf(str);
					boolean weaponContained = false;
					
					while (bunkers.size() > 1) {
						if (freeCapacity >= weaponCapacity) {
							freeCapacity -= weaponCapacity;
							weapons.add(weaponCapacity);
							weaponContained = true;
							break;
						}
						if (weapons.size() == 0) {
							System.out.printf("%s -> Empty%n", bunkers.peek());
						} else {
							System.out.printf("%s -> %s%n", bunkers.peek(), weapons.toString().replaceAll("[\\[\\]]", ""));
						}
						bunkers.remove();
						weapons.clear();
						freeCapacity = capacity;
					}
					if (!weaponContained && bunkers.size() == 1) {
						if (capacity >= weaponCapacity) {
							if (freeCapacity < weaponCapacity) {
								
								while (freeCapacity < weaponCapacity) {
									int removedWeapon = weapons.remove();
									freeCapacity += removedWeapon;
								}
							}
							weapons.add(weaponCapacity);
							freeCapacity -= weaponCapacity;
						}
					}
				}
			}
		}
	}
}
