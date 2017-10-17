import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FootballStats {
	
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		Map<String, List<TeamsAndScores>> teams = new LinkedHashMap<>();
		String input;
		
		Pattern pattern = Pattern.compile("(?<firstTeam>[a-zA-Z]+)[\\s-]+(?<secondTeam>[a-zA-Z]+)\\s+result\\s+(?<firstTeamGoals>\\d+):(?<secondTeamGoals>\\d+)");
		while (!(input = read.readLine()).equals("Season End")) {
			Matcher matcher = pattern.matcher(input);
			
			while (matcher.find()) {
				String firstTeam = matcher.group("firstTeam");
				String secondTeam = matcher.group("secondTeam");
				String firstTeamGoals = matcher.group("firstTeamGoals");
				String secondTeamGoals = matcher.group("secondTeamGoals");
				
				TeamsAndScores teamsAndScores1 = new TeamsAndScores(firstTeam + " - " + secondTeam, firstTeamGoals + ":" + secondTeamGoals);
				TeamsAndScores teamsAndScores2 = new TeamsAndScores(secondTeam + " - " + firstTeam, secondTeamGoals + ":" + firstTeamGoals);
				teams.putIfAbsent(firstTeam, new LinkedList<>());
				teams.get(firstTeam).add(teamsAndScores1);
				teams.putIfAbsent(secondTeam, new LinkedList<>());
				teams.get(secondTeam).add(teamsAndScores2);
			}
		}
		String[] sortTeams = read.readLine().split(", ");
		for (String sortTeam : sortTeams) {
			teams.entrySet().stream()
					.filter(a -> a.getKey().equals(sortTeam))
					.forEach(res -> {
						res.getValue().stream()
								.sorted(Comparator.comparing(TeamsAndScores::getTeam))
								.forEach(s -> System.out.printf("%s -> %s%n", s.getTeam(), s.getResult()));
					});
		}
	}
}

class TeamsAndScores {
	private String team;
	private String result;
	
	public TeamsAndScores(String team, String result) {
		this.setTeam(team);
		this.setResult(result);
	}
	
	public String getTeam() {
		return this.team;
	}
	
	private void setTeam(String team) {
		this.team = team;
	}
	
	public String getResult() {
		return this.result;
	}
	
	private void setResult(String result) {
		this.result = result;
	}
}
