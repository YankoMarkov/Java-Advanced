import java.io.File;

public class ListFiles {
	
	public static void main(String[] args) {
		File file = new File("E:\\Java-Advanced-new\\InputOutput, Files and Directories\\Files-and-Streams");
		if (file.exists()) {
			if (file.isDirectory()) {
				File[] files = file.listFiles();
				for (File file1 : files) {
					if (!file1.isDirectory()) {
						System.out.println(file1.getName() + ": " + file1.length());
					}
				}
			}
		}
	}
}
