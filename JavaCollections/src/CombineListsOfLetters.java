
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CombineListsOfLetters {

    private static List<Character> addCharacters(String[] str, List<Character> list) {
        for (String s : str) {
            list.add(s.charAt(0));
        }
        return list;
    }

    private static List<Character> addCharactersFroml2(List<Character> temp, List<Character> l1, List<Character> l2) {
        for (Character character : l2) {
            if (!l1.contains(character)) {
                temp.add(character);
            }
        }
        return temp;
    }


    private static void printResult(List<Character> l1, List<Character> temp) {
        for (Character character : temp) {
            l1.add(character);
        }
        for (Character character : l1) {
            System.out.print(character + " ");
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter text1:");
        String[] text1 = input.nextLine().split(" ");
        System.out.println("Enter text2:");
        String[] text2 = input.nextLine().split(" ");
        List<Character> l1 = new ArrayList<>();
        List<Character> l2 = new ArrayList<>();
        List<Character> result = new ArrayList<>();
        List<Character> temp = new ArrayList<>();
        l1 = addCharacters(text1, l1);
        l2 = addCharacters(text2, l2);
        temp = addCharactersFroml2(temp, l1, l2);
        printResult(l1, temp);
    }
}
