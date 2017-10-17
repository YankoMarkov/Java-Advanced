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
		Map<String, Integer> playerTotalScore = new HashMap<>();
		String inputs = null;
		
		Pattern pattern = Pattern.compile("(?<score1>\\d+)\\s+(?<player1>[a-zA-Z]+)<->(?<player2>[a-zA-Z]+)\\s+(?<score2>\\d+)");
		
		while (!(inputs = read.readLine()).equals("osu!")) {
			Matcher matcher = pattern.matcher(inputs);
			String player1 = "";
			String player2 = "";
			int score1 = 0;
			int score2 = 0;
			
			while (matcher.find()) {
				score1 = Integer.valueOf(matcher.group("score1"));
				player1 = matcher.group("player1");
				player2 = matcher.group("player2");
				score2 = Integer.valueOf(matcher.group("score2"));
				
				if (!result.containsKey(player1)) {
					result.put(player1, new ArrayList<>());
					playerTotalScore.put(player1, (score1 - score2));
				} else {
					playerTotalScore.put(player1, playerTotalScore.get(player1) + (score1 - score2));
				}
				if (!result.containsKey(player2)) {
					result.put(player2, new ArrayList<>());
					playerTotalScore.put(player2, (score2 - score1));
				} else {
					playerTotalScore.put(player2, playerTotalScore.get(player2) + (score2 - score1));
				}
				if (!result.get(player1).contains(player2)) {
					result.get(player1).add(String.format("*   %s <-> %d", player2, (score1 - score2)));
				}
				if (!result.get(player2).contains(player1)) {
					result.get(player2).add(String.format("*   %s <-> %d", player1, (score2 - score1)));
				}
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
