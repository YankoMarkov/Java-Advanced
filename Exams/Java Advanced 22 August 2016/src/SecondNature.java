import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class SecondNature {
	
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		List<Integer> inputFlowers = Arrays.stream(read.readLine().split(" ")).map(Integer::valueOf).collect(Collectors.toList());
		List<Integer> inputBuckets = Arrays.stream(read.readLine().split(" ")).map(Integer::valueOf).collect(Collectors.toList());
		Collections.reverse(inputBuckets);
		Deque<Integer> flowers = new ArrayDeque<>();
		Deque<Integer> buckets = new ArrayDeque<>();
		List<Integer> secondNature = new ArrayList<>();
		flowers.addAll(inputFlowers);
		buckets.addAll(inputBuckets);
		
		int index = 0;
		while (index < flowers.size()) {
			index++;
			int bucket = buckets.peek();
			int flower = flowers.peek();
			if (buckets.size() == 1) {
				if (bucket - flower > 0) {
					flowers.pop();
					buckets.pop();
					buckets.push(bucket - flower);
					index = 0;
				} else if (bucket - flower < 0) {
					buckets.pop();
					flowers.pop();
					flowers.push(flower - bucket);
					break;
				} else if (bucket - flower == 0) {
					secondNature.add(flowers.pop());
					buckets.pop();
					break;
				}
			} else {
				if (bucket - flower > 0) {
					flowers.pop();
					buckets.pop();
					int firstBucket = buckets.pop();
					buckets.push(firstBucket + (bucket - flower));
					index = 0;
				} else if (bucket - flower < 0) {
					buckets.pop();
					flowers.pop();
					flowers.push(flower - bucket);
					index = 0;
				} else if (bucket - flower == 0) {
					secondNature.add(flowers.pop());
					buckets.pop();
					index = 0;
				}
			}
		}
		if (flowers.isEmpty()) {
			System.out.println(Arrays.toString(buckets.toArray()).replaceAll("[\\[\\],]", ""));
		} else {
			System.out.println(Arrays.toString(flowers.toArray()).replaceAll("[\\[\\],]", ""));
		}
		if (secondNature.isEmpty()) {
			System.out.println("None");
		} else {
			System.out.println(Arrays.toString(secondNature.toArray()).replaceAll("[\\[\\],]", ""));
		}
	}
}
