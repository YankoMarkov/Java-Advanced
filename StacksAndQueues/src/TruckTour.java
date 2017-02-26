
import java.util.ArrayDeque;
import java.util.Scanner;

public class TruckTour {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = Integer.valueOf(input.nextLine());
        ArrayDeque<Station> queu = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            String[] token = input.nextLine().split(" ");
            int gas = Integer.parseInt(token[0]);
            int distance = Integer.parseInt(token[1]);
            Station station = new Station();
            station.gasGiven = gas;
            station.distanceToNext = distance;
            queu.addLast(station);
        }

        int gasInTank = 0;
        boolean foundFirst = false;
        int index = 0;

        while (true) {
            Station currentStation = queu.removeFirst();
            gasInTank += currentStation.gasGiven;
            queu.addLast(currentStation);

            Station firstStation = currentStation;
            int indexAddUp = 1;

            while (gasInTank >= currentStation.distanceToNext) {
                gasInTank -= currentStation.distanceToNext;
                currentStation = queu.removeFirst();
                queu.addLast(currentStation);
                gasInTank += currentStation.gasGiven;
                indexAddUp++;

                if (currentStation == firstStation) {
                    foundFirst = true;
                    break;
                }
            }

            if (foundFirst) {
                break;
            }

            index += indexAddUp;
            gasInTank = 0;
        }

        System.out.println(index);

    }
}

class Station {
    int gasGiven;
    int distanceToNext;
}
