import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class PascalsTriangle {
	
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		int size = Integer.parseInt(read.readLine());
		
		BigInteger[][] pascal = new BigInteger[size + 1][];
		pascal[1] = new BigInteger[3];
		pascal[1][1] = new BigInteger("1");
		
		for (int i = 2; i <= size; i++) {
			pascal[i] = new BigInteger[i + 2];
			
			for (int j = 1; j < pascal[i].length - 1; j++) {
				if (pascal[i - 1][j - 1] == null) {
					pascal[i - 1][j - 1] = new BigInteger("0");
				}
				
				if (pascal[i - 1][j] == null) {
					pascal[i - 1][j] = new BigInteger("0");
				}
				
				pascal[i][j] = pascal[i - 1][j - 1].add(pascal[i - 1][j]);
			}
		}
		
		for (int i = 1; i <= size; i++) {
			for (int j = 1; j < pascal[i].length - 1; j++) {
				System.out.print(pascal[i][j] + " ");
			}
			System.out.println();
		}
	}
}