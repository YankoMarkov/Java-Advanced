import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CubicsRube {
	
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.valueOf(read.readLine());
		int[][][] cube = new int[num][num][num];
		
		String inputs;
		while (!(inputs = read.readLine()).equals("Analyze")) {
			int[] input = Arrays.stream(inputs.split("\\s+")).mapToInt(Integer::valueOf).toArray();
			int first = input[0];
			int second = input[1];
			int third = input[2];
			int particles = input[3];
			try {
				if (cube[first][second][third] == 0) {
					cube[first][second][third] = particles;
				}
			} catch (IndexOutOfBoundsException e) {
			}
		}
		long totalParticles = 0;
		int totalCells = 0;
		for (int[][] ints : cube) {
			for (int[] anInt : ints) {
				for (int i : anInt) {
					if (i == 0) {
						totalCells++;
					} else {
						totalParticles += i;
					}
				}
			}
		}
		System.out.println(totalParticles);
		System.out.println(totalCells);
	}
}
