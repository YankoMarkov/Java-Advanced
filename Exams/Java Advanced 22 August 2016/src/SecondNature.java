import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SecondNature {

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> flowers = Arrays.stream(read.readLine().split(" ")).map(Integer::valueOf).collect(Collectors.toList());
        List<Integer> buckets = Arrays.stream(read.readLine().split(" ")).map(Integer::valueOf).collect(Collectors.toList());
        Collections.reverse(buckets);
        List<Integer> secondNature = new ArrayList<>();

        for (int i = 0; i < flowers.size(); i++) {
            for (int j = 0; j < buckets.size(); j++) {
                int diff = buckets.get(j) - flowers.get(i);
                if (buckets.size() == 1) {
                    if (diff < 0) {
                        int temp = flowers.get(i) - buckets.get(j);
                        flowers.set(i, temp);
                        buckets.remove(j);
                        i = -1;
                        break;
                    }
                    if (diff > 0) {
                        buckets.set(j, diff);
                        flowers.remove(i);
                        i = -1;
                        break;
                    }
                    if (diff == 0) {
                        secondNature.add(flowers.get(i));
                        buckets.remove(j);
                        flowers.remove(i);
                        i = -1;
                        break;
                    }
                }
                if (diff < 0) {
                    int temp = flowers.get(i) - buckets.get(j);
                    flowers.set(i, temp);
                    buckets.remove(j);
                    i = -1;
                    break;
                }
                if (diff > 0) {
                    int temp = diff + buckets.get(j + 1);
                    buckets.set(j + 1, temp);
                    buckets.remove(j);
                    flowers.remove(i);
                    i = -1;
                    break;
                }
                if (diff == 0) {
                    secondNature.add(flowers.get(i));
                    buckets.remove(j);
                    flowers.remove(i);
                    i = -1;
                    break;
                }
            }
        }
        if (flowers.isEmpty()) {
            for (Integer bucket : buckets) {
                System.out.printf("%d ", bucket);
            }
            System.out.println();
        } else {
            for (Integer flower : flowers) {
                System.out.printf("%d ", flower);
            }
            System.out.println();
        }
        if (secondNature.isEmpty()) {
            System.out.println("None");
        } else {
            for (Integer integer : secondNature) {
                System.out.printf("%d ", integer);
            }
        }
    }
}
