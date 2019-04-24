//https://www.hackerrank.com/challenges/ctci-making-anagrams/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=strings
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.stream.Collectors;

public class Solution {

    // Complete the makeAnagram function below.
    static int makeAnagram(String a, String b) {
        //create result anogram
        StringBuilder anagram = new StringBuilder();
        int result = 0;

        //sort lexo
        char[] firstArray = a.toCharArray();
        char[] secondArray = b.toCharArray();
        List<Character> first = new ArrayList<>();
        List<Character> second = new ArrayList<>();

        for (Character c : firstArray) {
            first.add(c);
        }

        for (Character c : secondArray) {
            second.add(c);
        }

        for (Character c : first) {
            System.out.print(String.format("%c", c));
        }
        System.out.println();

        for (Character c : second) {
            System.out.print(String.format("%c", c));
        }
        System.out.println();

        first = first.stream().sorted().collect(Collectors.toList());
        second = second.stream().sorted().collect(Collectors.toList());

        for (Character c : first) {
            System.out.print(String.format("%c", c));
        }
        System.out.println();

        for (Character c : second) {
            System.out.print(String.format("%c", c));
        }
        System.out.println();

        //for a->z
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        int[] topCount = new int[26];
        int[] botCount = new int[26];

        //count
        int i = 0;
        for (char c : alphabet) {
            for (char u : first) {
                if (u == c) {
                    topCount[i]++;
                }
            }

            for (char u : second) {
                if (u == c) {
                    botCount[i]++;
                }
            }

            int diffChar = Math.abs(topCount[i]-botCount[i]);
            System.out.println(String.format("%c->(%d,%d) rem:%d", c, topCount[i], botCount[i], diffChar));
            result += diffChar;

            i++;
        }

        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String a = scanner.nextLine();

        String b = scanner.nextLine();

        int res = makeAnagram(a, b);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}


