package ru.nippyfox.java_lab1;

import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String words = in.nextLine();
        String[] array = words.split(" ");
        for (String s : array) {
            System.out.println(s + ": " + isPalindrome(s));
        }
    }

    public static String reverseString(String s) { // Reverse stirng
        String result = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            result += s.charAt(i);
        }
        return result;
    }

    public static boolean isPalindrome(String s) { // Checking if word is palindrome
        return s.equals(reverseString(s));
    }
}
