
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LegoBlocks {

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(read.readLine());

        List<List<Integer>> firstMatrix = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] numbers = read.readLine().trim().split("\\s+");
            firstMatrix.add(new ArrayList<>());
            for (String number : numbers) {
                firstMatrix.get(i).add(Integer.valueOf(number));
            }
        }

        List<List<Integer>> secondMatrix = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] numbers = read.readLine().trim().split("\\s+");
            secondMatrix.add(new ArrayList<>());
            for (int j = numbers.length - 1; j >= 0; j--) {
                secondMatrix.get(i).add(Integer.valueOf(numbers[j]));
            }
        }

        int length = firstMatrix.get(0).size() + secondMatrix.get(0).size();
        int count = length;
        boolean someLength = true;
        for (int i = 1; i < n; i++) {
            if (length != firstMatrix.get(i).size() + secondMatrix.get(i).size()) {
                someLength = false;
            }
            count += firstMatrix.get(i).size() + secondMatrix.get(i).size();
        }
        if (someLength) {
            for (int i = 0; i < n; i++) {
                System.out.printf("[%s, %s]\n", firstMatrix.get(i).stream().map(Object::toString).collect(Collectors.joining(", ")),
                        secondMatrix.get(i).stream().map(Object::toString).collect(Collectors.joining(", ")));
            }
        } else {
            System.out.println("The total number of cells is: " + count);
        }
    }
}
