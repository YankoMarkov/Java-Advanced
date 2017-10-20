package javaCollections;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FilterArray {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter text:");
        String[] text = input.nextLine().split("\\W+");
        List<String> filterText = new ArrayList<>();
        if (filterText.isEmpty()) {
            System.out.println("(empty)");
        }
        for (String txt : text) {
            filterText.add(txt);
        }
        filterText.stream().filter(i -> i.length() > 3).forEach(i -> System.out.print(i + " "));
    }
}
