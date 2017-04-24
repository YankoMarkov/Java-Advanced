import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ToTheStars {

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        String[] star1 = read.readLine().split("\\s+");
        String nameStar1 = star1[0];
        double xStar1 = Double.valueOf(star1[1]);
        double yStar1 = Double.valueOf(star1[2]);
        String[] star2 = read.readLine().split("\\s+");
        String nameStar2 = star2[0];
        double xStar2 = Double.valueOf(star2[1]);
        double yStar2 = Double.valueOf(star2[2]);
        String[] star3 = read.readLine().split("\\s+");
        String nameStar3 = star3[0];
        double xStar3 = Double.valueOf(star3[1]);
        double yStar3 = Double.valueOf(star3[2]);
        String[] normandy = read.readLine().split("\\s+");
        double xNormandy = Double.valueOf(normandy[0]);
        double yNormandy = Double.valueOf(normandy[1]);
        int turns = Integer.valueOf(read.readLine());

        for (int i = 0; i < turns + 1; i++) {
            if (xNormandy >= xStar1 - 1 && xNormandy <= xStar1 + 1 &&
                    yNormandy >= yStar1 - 1 && yNormandy <= yStar1 + 1) {
                System.out.println(nameStar1.toLowerCase());
                yNormandy++;
                continue;
            }
            if (xNormandy >= xStar2 - 1 && xNormandy <= xStar2 + 1 &&
                    yNormandy >= yStar2 - 1 && yNormandy <= yStar2 + 1) {
                System.out.println(nameStar2.toLowerCase());
                yNormandy++;
                continue;
            }
            if (xNormandy >= xStar3 - 1 && xNormandy <= xStar3 + 1 &&
                    yNormandy >= yStar3 - 1 && yNormandy <= yStar3 + 1) {
                System.out.println(nameStar3.toLowerCase());
                yNormandy++;
            } else {
                System.out.println("space");
                yNormandy++;
            }

        }
    }
}
