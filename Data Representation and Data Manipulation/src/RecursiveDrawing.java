import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;

public class RecursiveDrawing {
	
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		int number = Integer.valueOf(read.readLine());
		
		drawFigure(number);
	}
	
	private static void drawFigure(int number) {
		if (number == 0) {
			return;
		} else {
			System.out.println(String.join("", Collections.nCopies(number, "*")));
			drawFigure(number - 1);
			System.out.println(String.join("", Collections.nCopies(number, "#")));
		}
	}
}
