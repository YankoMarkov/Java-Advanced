import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class TruckTour {
	
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.valueOf(read.readLine());
		Deque<Station> queu = new ArrayDeque<>();
		
		for (int i = 0; i < num; i++) {
			int[] input = Arrays.stream(read.readLine().split("\\s+")).mapToInt(Integer::valueOf).toArray();
			int gas = input[0];
			int distance = input[1];
			
			Station station = new Station();
			station.gasGiven = gas;
			station.distanceToNext = distance;
			queu.add(station);
		}
		int gasInTank = 0;
		boolean foundFirst = false;
		int index = 0;
		
		while (true) {
			Station currentStation = queu.remove();
			gasInTank += currentStation.gasGiven;
			queu.add(currentStation);
			
			Station firstStation = currentStation;
			int indexAddUp = 1;
			
			while (gasInTank >= currentStation.distanceToNext) {
				gasInTank -= currentStation.distanceToNext;
				currentStation = queu.remove();
				queu.add(currentStation);
				gasInTank += currentStation.gasGiven;
				indexAddUp++;
				
				if (currentStation == firstStation) {
					foundFirst = true;
					break;
				}
			}
			
			if (foundFirst) {
				break;
			}
			
			index += indexAddUp;
			gasInTank = 0;
		}
		
		System.out.println(index);
	}
}

class Station {
	int gasGiven;
	int distanceToNext;
}
