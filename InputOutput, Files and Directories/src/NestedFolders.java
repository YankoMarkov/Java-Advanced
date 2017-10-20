import java.io.File;
import java.util.ArrayDeque;
import java.util.Deque;

public class NestedFolders {
	
	public static void main(String[] args) {
		File file = new File("E:\\Java-Advanced-new\\InputOutput, Files and Directories\\Files-and-Streams");
		Deque<File> queue = new ArrayDeque<>();
		queue.add(file);
		int count = 0;
		while (!queue.isEmpty()) {
			File current = queue.poll();
			System.out.println(current.getName());
			count++;
			for (File dir : current.listFiles()) {
				if (dir.isDirectory()) {
					queue.add(dir);
				}
			}
		}
		System.out.println(count + " folders");
	}
}
