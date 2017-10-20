
import java.util.Scanner;

public class SequencesOfEqualStrings {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter strings separate with space: ");
        String[] str = input.nextLine().split(" ");
        for (int i = 0; i < str.length; i++) {
            System.out.print(str[i] + " ");
            while (i < str.length - 1 && str[i].equals(str[i + 1])) {
                System.out.print(str[i + 1] + " ");
                i++;
            }
            System.out.println();
        }
    }
}
