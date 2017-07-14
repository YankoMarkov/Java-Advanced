
import java.util.ArrayDeque;
import java.util.Scanner;


public class Royalism {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] txt = scan.nextLine().split(" ");
        ArrayDeque<String> royals = new ArrayDeque<>();
        ArrayDeque<String> nonRoyals = new ArrayDeque<>();

        int sum = 0;

        for (int i = 0; i < txt.length; i++) {
            String str = txt[i];
            for (int j = 0; j < str.length(); j++) {
                char ch = str.charAt(j);
                sum = (sum + ch) % 26;
            }
            if (sum == 18) {
                royals.add(str);
                sum = 0;
            } else {
                nonRoyals.add(str);
                sum = 0;
            }
        }
        if (royals.size() >= nonRoyals.size() && royals.size() > 0) {
            System.out.println("Royalists - " + royals.size());
            while (royals.size() != 0) {
                System.out.println(royals.removeFirst());
            }
            System.out.println("All hail Royal!");
        } else {
            while (nonRoyals.size() != 0) {
                System.out.println(nonRoyals.removeFirst());
            }
            System.out.println("Royalism, Declined!");
        }
    }
}
