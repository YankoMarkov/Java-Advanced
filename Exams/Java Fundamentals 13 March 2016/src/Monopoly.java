
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Monopoly {
	
	private static String[] readMatrix(BufferedReader read, int row) throws IOException {
		String[] result = new String[row];
		for (int rows = 0; rows < row; rows++) {
			result[rows] = read.readLine();
		}
		return result;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		int[] rowCol = Arrays.stream(read.readLine().split("\\s+")).mapToInt(Integer::valueOf).toArray();
		int row = rowCol[0];
		int col = rowCol[1];
		int money = 50;
		int hotelsCount = 0;
		int turns = 0;
		
		String[] matrix = readMatrix(read, row);
		boolean moveRight = true;
		
		for (int rows = 0; rows < row; rows++) {
			if (moveRight) {
				for (int cols = 0; cols < col; cols++) {
					char letter = matrix[rows].charAt(cols);
					
					switch (letter) {
						case 'H':
							hotelsCount++;
							System.out.printf("Bought a hotel for %d. Total hotels: %d.\n", money, hotelsCount);
							money = 0;
							break;
						case 'J':
							System.out.printf("Gone to jail at turn %d.\n", turns);
							turns += 2;
							money += (hotelsCount * 10) * 2;
							break;
						case 'S':
							int spendMoney = (rows + 1) * (cols + 1);
							spendMoney = spendMoney > money ? money : spendMoney;
							money -= spendMoney;
							System.out.printf("Spent %d money at the shop.\n", spendMoney);
							break;
						default:
							break;
					}
					money += hotelsCount * 10;
					turns++;
				}
				moveRight = false;
			} else {
				for (int cols = col - 1; cols >= 0; cols--) {
					char letter = matrix[rows].charAt(cols);
					
					switch (letter) {
						case 'H':
							hotelsCount++;
							System.out.printf("Bought a hotel for %d. Total hotels: %d.\n", money, hotelsCount);
							money = 0;
							break;
						case 'J':
							System.out.printf("Gone to jail at turn %d.\n", turns);
							turns += 2;
							money += (hotelsCount * 10) * 2;
							break;
						case 'S':
							int spendMoney = (rows + 1) * (cols + 1);
							spendMoney = spendMoney > money ? money : spendMoney;
							money -= spendMoney;
							System.out.printf("Spent %d money at the shop.\n", spendMoney);
							break;
						default:
							break;
					}
					money += hotelsCount * 10;
					turns++;
				}
				moveRight = true;
			}
		}
		System.out.printf("Turns %d\n", turns);
		System.out.printf("Money %d\n", money);
	}
}
