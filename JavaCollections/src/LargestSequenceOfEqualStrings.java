
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LargestSequenceOfEqualStrings {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter strings separate with interval:");
        String[] str = input.nextLine().split(" ");
        List<String> sequence = new ArrayList<>();
        for (int i = 0; i < str.length; i++) {
            List<String> temp = new ArrayList<>();
            temp.add(str[i]);
            while (i < str.length - 1 && str[i].equals(str[i + 1])) {
                temp.add(str[i + 1]);
                i++;
            }
            if (temp.size() > sequence.size()) {
                sequence.clear();
                sequence.addAll(temp);
            }
        }
        System.out.println(sequence);
    }
}
