
import java.util.Scanner;

public class GetAverage {

    public static void Average (int a, int b, int c) {
        int n1 = a;
        int n2 = b;
        int n3 = c;
        int sum;
        sum = n1 + n2 + n3;
        float average = (float) sum / 3;
        System.out.printf("Average numbers is: %.2f", average);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number a= ");
        int a = input.nextInt();
        System.out.print("Enter number b= ");
        int b = input.nextInt();
        System.out.print("Enter number c= ");
        int c = input.nextInt();
        Average(a, b, c);
    }
}
