
import java.util.Scanner;

public class CalculateNfacturial {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter N: ");
        int n = input.nextInt();
        int facturial = 1;
        for (int i = n; i >= 1 ; i--) {
            facturial *= i;
        }
        System.out.println("N!= " + facturial);
    }
}
