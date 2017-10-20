
import java.util.Scanner;

public class CountSpecifiedWord {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter text:");
        String[] str = input.nextLine().split("[\\W]+");
        System.out.println("Enter word to count:");
        String word = input.nextLine();
        int count = 0;
        for (int i = 0; i < str.length; i++) {
            String temp = str[i];
            if (word.toLowerCase().equals(temp.toLowerCase())) {
                count++;
            }
        }
        System.out.println("Word " + word + " appears " + count + " times.");
    }
}
