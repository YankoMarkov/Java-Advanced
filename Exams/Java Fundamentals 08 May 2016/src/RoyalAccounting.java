
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class RoyalAccounting {
	
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		
		List<String> allEmploys = new ArrayList<>();
		Map<String, Map<String, Double[]>> databaseByTeam = new LinkedHashMap<>();
		
		Pattern pattern = Pattern.compile("\\b(?<!:|-|_)([a-zA-Z]+);([-0-9]+);([-0-9.]+);([a-zA-Z]+)\\b");
		String input = null;
		
		while (!(input = read.readLine()).equals("Pishi kuf i da si hodim")) {
			String match = input.replaceAll(" ", "_");
			Matcher matcher = pattern.matcher(match);
			
			while (matcher.find()) {
				String name = matcher.group(1);
				double workHoursPerDay = Double.valueOf(matcher.group(2));
				double dailyPayment = Double.valueOf(matcher.group(3));
				String team = matcher.group(4);
				
				if (!allEmploys.contains(name)) {
					if (databaseByTeam.containsKey(team)) {
						Double[] employeeCharacteristics = new Double[]{workHoursPerDay, dailyPayment};
						databaseByTeam.get(team).put(name, employeeCharacteristics);
					} else {
						Double[] employeeCharacteristics = new Double[]{workHoursPerDay, dailyPayment};
						Map<String, Double[]> currentEmployees = new LinkedHashMap<>();
						currentEmployees.put(name, employeeCharacteristics);
						databaseByTeam.put(team, currentEmployees);
					}
					allEmploys.add(name);
				}
			}
		}
		
		Map<String, Map<String, Double[]>> sortedDatabaseByTeam = databaseByTeam.entrySet().stream()
				.sorted((team1, team2) -> {
					Double firsTeam = team1.getValue().values().stream()
							.mapToDouble(employeeCredentials -> ((employeeCredentials[0] * employeeCredentials[1]) / 24) * 30).sum();
					Double secondTeam = team2.getValue().values().stream()
							.mapToDouble(employeeCredentials -> ((employeeCredentials[0] * employeeCredentials[1]) / 24) * 30).sum();
					return secondTeam.compareTo(firsTeam);
				})
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (x, y) -> {
					throw new AssertionError();
				}, LinkedHashMap::new));
		
		for (Map.Entry<String, Map<String, Double[]>> currentTeam : sortedDatabaseByTeam.entrySet()) {
			System.out.printf("Team - %s\n", currentTeam.getKey());
			Map<String, Double[]> sortedEmployee = currentTeam.getValue().entrySet().stream()
					.sorted((employee1, employee2) -> {
						Integer result = employee2.getValue()[0].compareTo(employee1.getValue()[0]);
						if (result.equals(0)) {
							Double firstEmployeeDailyIncome = (employee1.getValue()[0] * employee1.getValue()[1]) / 24;
							Double secondEmployeeDailyIncome = (employee2.getValue()[0] * employee2.getValue()[1]) / 24;
							result = secondEmployeeDailyIncome.compareTo(firstEmployeeDailyIncome);
							if (result.equals(0)) {
								result = employee1.getKey().compareTo(employee2.getKey());
							}
						}
						return result;
					})
					.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (x, y) -> {
						throw new AssertionError();
					}, LinkedHashMap::new));
			
			for (Map.Entry<String, Double[]> currentEmployee : sortedEmployee.entrySet()) {
				System.out.printf("$$$%s - %s - %f\n", currentEmployee.getKey(),
						currentEmployee.getValue()[0].intValue(),
						(currentEmployee.getValue()[0] * currentEmployee.getValue()[1]) / 24);
			}
		}
	}
}


