import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Earthquake {
	
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.valueOf(read.readLine());
		List<Integer> waves = new ArrayList<>();
		Deque<Deque<Integer>> activities = new ArrayDeque<>();
		
		for (int i = 0; i < num; i++) {
			int[] temp = Arrays.stream(read.readLine().split("\\s+")).mapToInt(Integer::valueOf).toArray();
			Deque<Integer> seismic = new ArrayDeque<>();
			for (int s : temp) {
				seismic.add(s);
			}
			activities.add(seismic);
		}
		
		while (!activities.isEmpty()) {
			Deque<Integer> seismic = activities.pop();
			
			int seismicity = seismic.pop();
			int iterateLength = seismic.size();
			
			for (int j = 0; j < iterateLength; j++) {
				int nextSeismic = seismic.pop();
				if (seismicity < nextSeismic) {
					seismic.push(nextSeismic);
					activities.add(seismic);
					break;
				}
			}
			waves.add(seismicity);
		}
		System.out.println(waves.size());
		for (Integer integer : waves) {
			System.out.printf("%d ", integer);
		}
	}
}
