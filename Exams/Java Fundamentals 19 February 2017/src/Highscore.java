import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Highscore {
	
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		Map<String, List<String>> result = new HashMap<>();
		Map<String, Long> playerTotalScore = new HashMap<>();
		String inputs = null;
		
		while (!(inputs = read.readLine()).equals("osu!")) {
			String[] input = inputs.split("<->");
			String[] first = input[0].split(" ");
			String[] second = input[1].split(" ");
			String player1 = first[1];
			String player2 = second[0];
			long score1 = Long.valueOf(first[0]);
			long score2 = Long.valueOf(second[1]);
			
			if (!result.containsKey(player1)) {
				result.put(player1, new LinkedList<>());
				playerTotalScore.put(player1, (score1 - score2));
			} else {
				playerTotalScore.put(player1, playerTotalScore.get(player1) + (score1 - score2));
			}
			if (!result.get(player1).contains(player2)) {
				result.get(player1).add(String.format("*   %s <-> %d", player2, (score1 - score2)));
			}
			if (!result.containsKey(player2)) {
				result.put(player2, new LinkedList<>());
				playerTotalScore.put(player2, (score2 - score1));
			} else {
				playerTotalScore.put(player2, playerTotalScore.get(player2) + (score2 - score1));
			}
			if (!result.get(player2).contains(player1)) {
				result.get(player2).add(String.format("*   %s <-> %d", player1, (score2 - score1)));
			}
		}
		result.entrySet().stream()
				.sorted((s1, s2) -> playerTotalScore.get(s2.getKey()).compareTo(playerTotalScore.get(s1.getKey())))
				.forEach(player -> {
					System.out.printf("%s - (%d)\n", player.getKey(), playerTotalScore.get(player.getKey()));
					for (String s : player.getValue()) {
						System.out.println(s);
					}
				});
	}
}

