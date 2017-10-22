import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class ChampionsLeague {
	
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		Map<String, Set<String>> teamsWithOpponents = new TreeMap<>();
		Map<String, Integer> teamWithScore = new TreeMap<>();
		String input = null;
		
		while (!(input = read.readLine()).equals("stop")) {
			String[] inputs = input.split("[|]+");
			String firstTeam = inputs[0].trim();
			String secondTeam = inputs[1].trim();
			String[] homeResult = inputs[2].trim().split(":");
			String[] awayResult = inputs[3].trim().split(":");
			
			int firstTeamHomeResult = Integer.valueOf(homeResult[0]);
			int firstTeamAwayResult = Integer.valueOf(awayResult[1]);
			
			int secondTeamHomeResult = Integer.valueOf(awayResult[0]);
			int secondTeamAwayResult = Integer.valueOf(homeResult[1]);
			
			if (!teamsWithOpponents.containsKey(firstTeam)) {
				teamsWithOpponents.put(firstTeam, new TreeSet<>());
			}
			teamsWithOpponents.get(firstTeam).add(secondTeam);
			
			if (!teamsWithOpponents.containsKey(secondTeam)) {
				teamsWithOpponents.put(secondTeam, new TreeSet<>());
			}
			teamsWithOpponents.get(secondTeam).add(firstTeam);
			
			if (firstTeamHomeResult + firstTeamAwayResult > secondTeamHomeResult + secondTeamAwayResult) {
				winTeam(teamWithScore, firstTeam);
				loseTeam(teamWithScore, secondTeam);
			} else if (firstTeamHomeResult + firstTeamAwayResult < secondTeamHomeResult + secondTeamAwayResult) {
				winTeam(teamWithScore, secondTeam);
				loseTeam(teamWithScore, firstTeam);
			} else if (firstTeamHomeResult + firstTeamAwayResult == secondTeamHomeResult + secondTeamAwayResult) {
				if (firstTeamAwayResult > secondTeamAwayResult) {
					winTeam(teamWithScore, firstTeam);
					loseTeam(teamWithScore, secondTeam);
				} else if (firstTeamAwayResult < secondTeamAwayResult) {
					winTeam(teamWithScore, secondTeam);
					loseTeam(teamWithScore, firstTeam);
				}
			}
		}
		Map<String, Integer> sortedTeamWithScore = teamWithScore.entrySet().stream()
				.sorted((w1, w2) -> w2.getValue().compareTo(w1.getValue()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (x, y) -> {
					throw new AssertionError();
				}, LinkedHashMap::new));
		
		for (Map.Entry<String, Integer> result : sortedTeamWithScore.entrySet()) {
			System.out.printf("%s\n", result.getKey());
			System.out.printf("- Wins: %s\n", result.getValue());
			System.out.printf("- Opponents: %s\n", String.join(", ", teamsWithOpponents.get(result.getKey())));
		}
	}
	
	private static void winTeam(Map<String, Integer> teamWithScore, String team) {
		if (!teamWithScore.containsKey(team)) {
			teamWithScore.put(team, 1);
		} else {
			teamWithScore.replace(team, teamWithScore.get(team) + 1);
		}
	}
	
	private static void loseTeam(Map<String, Integer> teamWithScore, String team) {
		if (!teamWithScore.containsKey(team)) {
			teamWithScore.put(team, 0);
		} else {
			teamWithScore.replace(team, teamWithScore.get(team));
		}
	}
}