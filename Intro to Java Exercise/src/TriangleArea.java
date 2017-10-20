import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TriangleArea {
	
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		String[] firstPoint = read.readLine().split("\\s+");
		String[] secondPoint = read.readLine().split("\\s+");
		String[] thirdPoint = read.readLine().split("\\s+");
		int side1x = Integer.valueOf(firstPoint[0]);
		int side1y = Integer.valueOf(firstPoint[1]);
		int side2x = Integer.valueOf(secondPoint[0]);
		int side2y = Integer.valueOf(secondPoint[1]);
		int side3x = Integer.valueOf(thirdPoint[0]);
		int side3y = Integer.valueOf(thirdPoint[1]);
		
		double area = Math.abs((side1x * (side2y - side3y) + side2x * (side3y - side1y) + side3x * (side1y - side2y)) / 2);
		
		System.out.printf("%.0f", area);
	}
}
