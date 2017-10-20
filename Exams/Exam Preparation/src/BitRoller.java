import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BitRoller {
	
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		int number = Integer.valueOf(read.readLine());
		int f = Integer.valueOf(read.readLine());
		int r = Integer.valueOf(read.readLine());
		
		char[] binary = String.format("%19s", Integer.toBinaryString(number)).replace(" ", "0").toCharArray();
		int index = (binary.length - 1) - f;
		
		for (int i = 0; i < r; i++) {
			rollBitsRight(binary, index);
		}
		int result = Integer.parseInt(Arrays.toString(binary).replaceAll("[\\[\\], ]", ""), 2);
		System.out.println(result);
	}
	
	private static void rollBitsRight(char[] bits, int index) {
		char[] newBits = new char[bits.length];
		for (int pos = 0; pos < bits.length; pos++) {
			if (pos == index) {
				newBits[pos] = bits[pos];
			} else {
				int newPos = (pos + 1) % bits.length;
				if (newPos == index) {
					newPos = (newPos + 1) % bits.length;
				}
				newBits[newPos] = bits[pos];
			}
		}
		for (int i = 0; i < bits.length; i++) {
			bits[i] = newBits[i];
		}
	}
}
