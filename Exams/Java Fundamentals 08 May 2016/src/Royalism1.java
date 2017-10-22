
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Royalism1 {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] str = scan.nextLine().split(" ");
		int[] sum = new int[1];
		
		List<String> nonRoyal = new ArrayList<>();
		List<String> royal = new ArrayList<>();
		
		Arrays.stream(str)
				.forEach(name -> {
					Arrays.stream(name.split(""))
							.forEach(character -> {
								sum[0] = (sum[0] + character.charAt(0)) % 26;
							});
					if (sum[0] == 18) {
						royal.add(name);
						sum[0] = 0;
					} else {
						nonRoyal.add(name);
						sum[0] = 0;
					}
				});
		if (royal.size() >= nonRoyal.size() && royal.size() > 0) {
			System.out.printf("Royalists - %s\n%s\nAll hail Royal!", royal.size(), String.join("\n", royal));
		} else {
			System.out.printf("%s\nRoyalism, Declined!", String.join("\n", nonRoyal));
		}
	}
}
