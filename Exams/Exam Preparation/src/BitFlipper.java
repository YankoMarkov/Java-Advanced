import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;

public class BitFlipper {
	
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		BigInteger input = new BigInteger(read.readLine());
		String binNum = input.toString(2);
		
		char[] binary = String.format("%64s", binNum).replaceAll(" ", "0").toCharArray();
		int i = 0;
		while (i < binary.length - 2) {
			if (binary[i] == binary[i + 1] && binary[i] == binary[i + 2]) {
				if (binary[i] == '0') {
					binary[i] = '1';
					binary[i + 1] = '1';
					binary[i + 2] = '1';
				} else {
					binary[i] = '0';
					binary[i + 1] = '0';
					binary[i + 2] = '0';
				}
				i += 3;
			} else {
				i++;
			}
		}
		String res = Arrays.toString(binary).replaceAll("[\\[\\], ]", "");
		BigInteger result = new BigInteger(res, 2);
		System.out.println(result);
	}
}
