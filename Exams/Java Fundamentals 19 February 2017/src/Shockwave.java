import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Shockwave {

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        String[] rowCol = read.readLine().split("\\s+");
        int rows = Integer.valueOf(rowCol[0]);
        int cols = Integer.valueOf(rowCol[1]);
        int[][] matrix = new int[rows][cols];
        String commands = null;

        while (!(commands = read.readLine()).equals("Here We Go")) {
            String[] command = commands.split("\\s+");
            int x1 = Integer.valueOf(command[0]);
            int y1 = Integer.valueOf(command[1]);
            int x2 = Integer.valueOf(command[2]);
            int y2 = Integer.valueOf(command[3]);

                for (int i = x1; i < matrix.length; i++) {
                    if (i == x2 + 1) {
                        break;
                    }
                    for (int j = y1; j < matrix[i].length; j++) {
                        matrix[i][j] += 1;
                        if (j == y2) {
                            break;
                        }
                    }
                }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.printf("%d ", matrix[i][j]);
            }
            System.out.println();
        }
    }
}
