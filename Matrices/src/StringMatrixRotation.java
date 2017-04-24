import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringMatrixRotation {

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        String command = read.readLine();
        Pattern pattern = Pattern.compile("(?<degree>\\d+)");
        Matcher matcher = pattern.matcher(command);
        int degrees = 0;
        while (matcher.find()) {
            degrees = Integer.valueOf(matcher.group("degree"));
        }
        if (degrees > 270) {
            while (degrees > 270) {
                degrees -= 360;
            }
        }
        List<String> allInput = new ArrayList<>();
        String input = null;

        int matrixLength = 0;
        int count = 0;
        while (!(input = read.readLine()).equals("END")) {
            count++;
            allInput.add(input);
            if (matrixLength <= input.length()) {
                matrixLength = input.length();
            }
        }
        char[][] matrix;

        switch (degrees) {
            case 0:
                for (int row = 0; row < count; row++) {
                    String temp = allInput.get(row);
                    for (int col = 0; col < temp.length(); col++) {
                        System.out.print(temp.charAt(col));
                    }
                    System.out.println();
                }
                break;
            case 90:
                matrix = new char[matrixLength][count];
                for (int col = 0; col < count; col++) {
                    String temp = allInput.get(allInput.size() - 1 - col);
                    for (int row = 0; row < temp.length(); row++) {
                        matrix[row][col] = temp.charAt(row);
                    }
                }
                for (char[] chars : matrix) {
                    for (char aChar : chars) {
                        if (aChar == 0) {
                            System.out.print(" ");
                        } else {
                            System.out.print(aChar);
                        }
                    }
                    System.out.println();
                }
                break;
            case 180:
                matrix = new char[count][matrixLength];
                for (int row = 0; row < count; row++) {
                    int col = matrixLength - 1;
                    String temp = allInput.get(allInput.size() - 1 - row);
                    for (int i = 0; i < temp.length(); i++) {
                        matrix[row][col] = temp.charAt(i);
                        col--;
                    }
                }
                for (char[] chars : matrix) {
                    for (char aChar : chars) {
                        if (aChar == 0) {
                            System.out.print(" ");
                        } else {
                            System.out.print(aChar);
                        }
                    }
                    System.out.println();
                }
                break;
            case 270:
                matrix = new char[matrixLength][count];
                for (int col = 0; col < count; col++) {
                    int row = matrixLength - 1;
                    String temp = allInput.get(col);
                    for (int i = 0; i < temp.length(); i++) {
                        matrix[row][col] = temp.charAt(i);
                        row--;
                    }
                }
                for (char[] chars : matrix) {
                    for (char aChar : chars) {
                        if (aChar == 0) {
                            System.out.print(" ");
                        } else {
                            System.out.print(aChar);
                        }
                    }
                    System.out.println();
                }
                break;
        }
    }
}
