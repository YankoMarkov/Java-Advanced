
import java.util.Scanner;

public class GhettoNumeralSystem {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number: ");
        String num = input.nextLine();
        String[] word = {"Gee", "Bro", "Zuz", "Ma", "Duh", "Yo", "Dis", "Hood", "Jam", "Mack"};
        for (int i = 0; i < num.length(); i++) {
            System.out.print(word[Integer.parseInt(String.valueOf(num.charAt(i)))]);
        }
    }
}
