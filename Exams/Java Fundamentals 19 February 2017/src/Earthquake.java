import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Earthquake {

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.valueOf(read.readLine());
        List<Integer> result = new ArrayList<>();
        Deque<List<Integer>> inputs = new ArrayDeque<>();

        for (int i = 0; i < num; i++) {
            List<Integer> temporary = Arrays.stream(read.readLine().split("\\s+")).map(Integer::valueOf).collect(Collectors.toList());
            inputs.add(temporary);
        }

        for (int i = 0; i <= inputs.size(); i++) {
            for (int j = 0; j < inputs.peek().size(); j++) {
                if (inputs.peek().size() == 1) {
                    result.add(inputs.peek().remove(0));
                    inputs.remove();
                    break;
                }
                if (inputs.peek().get(0) >= inputs.peek().get(1)) {
                    inputs.peek().remove(1);
                    j = 0;
                    continue;
                }
                if (inputs.peek().get(0) < inputs.peek().get(1)) {
                    result.add(inputs.peek().remove(0));
                    inputs.add(inputs.remove());
                    break;
                }
            }
            i = 0;
        }
        System.out.println(result.size());
        for (Integer integer : result) {
            System.out.printf("%d ", integer);
        }
    }
}
