
import java.util.Scanner;

public class CalculateExpression {

    public static void main(String[] args) {
        float a, b, c;
        float f1, f2, f3;
        float f1a, f1b, f2a, f2b;
        Scanner input = new Scanner(System.in);
        a = input.nextFloat();
        b = input.nextFloat();
        c = input.nextFloat();
        f1a = ((a * a) + (b * b)) / ((a * a) - (b * b));
        f1b = (float) ((a + b + c) / (Math.sqrt(c)));
        f1 = (float) Math.pow(f1a, f1b);
        f2a = ((a * a) + (b * b) - (c * c * c));
        f2b = a - b;
        f2 = (float) Math.pow(f2a, f2b);
        f3 = Math.abs(((a + b + c) / 3) - ((f1 + f2) / 2));
        System.out.printf("F1= %.2f%nF2= %.2f%nDiff= %.2f", f1, f2, f3);
    }
}
