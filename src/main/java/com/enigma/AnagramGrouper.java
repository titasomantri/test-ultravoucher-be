package com.enigma;
import java.util.*;

public class AnagramGrouper {

    public static List<List<String>> groupAnagrams(String[] words) {
        Map<String, List<String>> anagramGroups = new LinkedHashMap<>();

        for (String word : words) {
            char[] chars = word.toCharArray();
            manualSort(chars);
            String sortedWord = new String(chars);

            anagramGroups.putIfAbsent(sortedWord, new ArrayList<>());
            anagramGroups.get(sortedWord).add(word);
        }

        return new ArrayList<>(anagramGroups.values());
    }

    private static void manualSort(char[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    char temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        String[] words = {"cook", "save", "taste", "aves", "vase", "state", "map"};
        List<List<String>> result = groupAnagrams(words);
        System.out.println("[");
        for (List<String> group : result) {
            System.out.print(" [");
            for (int i = 0; i < group.size(); i++) {
                System.out.print("'" + group.get(i) + "'");
                if (i < group.size() - 1) {
                    System.out.print(",");
                }
            }
            System.out.println("],");
        }
        System.out.println("]");
    }
}
