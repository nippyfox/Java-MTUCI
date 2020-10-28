package ru.nippyfox.java_tasks_part2;

import java.util.*;
import java.lang.*;

public class Main {

    public static String repeat(String s, int n) { // 2.1
        String sum = "";
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < n; j++) {
                sum += arr[i];
            }
        }
        return sum;
    }

    public static int differenceMaxMin(int[] arr) { // 2.2
        if (arr.length == 0) {
            return 0;
        }
        else {
            int smallest = arr[0];
            int biggest = arr[0];
            for (int j : arr) {
                if (j > biggest) {
                    biggest = j;
                }
                if (j < smallest) {
                    smallest = j;
                }
            }
            return biggest - smallest;
        }
    }

    public static boolean isAvgWhole(int[] arr){ // 2.3
        int sum = 0;
        for (int i: arr){
            sum += i;
        }
        return sum % arr.length == 0;
    }

    public static int[] cumulativeSum(int[] arr){ // 2.4
        int[] res = new int[arr.length];
        res[0] = arr[0];
        int sum = 0;
        for (int i = 1; i <= arr.length-1; i++){
            sum += arr[i - 1];
            res[i] = arr[i] + sum;
        }
        return res;
    }

    public static int getDecimalPlaces(String a) { // 2.5
        if (a.contains(".")) {
            String result = a.substring(a.indexOf("."), a.length() - 1);
            return result.length();
        }
        else {
            return 0;
        }
    }

    public static int Fibonacci(int first) { // 2.6
        int a = 0;
        int b = 1;
        int result = 0 ;
        for (int i = 0; i < first; i++) {
            result = a + b;
            a = b;
            b = result;
        }
        return result;
    }

    public static boolean isValid(String a) { // 2.7
        if (a.length() == 5) {
            boolean c = true;
            for (int i = 0; i < 5; i++) {
                if (a.charAt(i) < 48 || a.charAt(i) > 57) {
                    c = false;
                    break;
                }
            }
            return c;
        }
        else {
            return false;
        }
    }

    public static boolean isStrangePair(String a, String b) { // 2.8
        return (a.charAt(0) == b.charAt(b.length() - 1)) && (b.charAt(0) == a.charAt(a.length() - 1));
    }

    public static boolean isPrefix(String a, String b) { // 2.9
        b = b.substring(0, b.length()-1);
        if (a.contains(b)) {
            return a.indexOf(b) == 0;
        }
        else {
            return false;
        }
    }

    public static boolean isSuffix(String a, String b) {
        b = b.substring(1, b.length());
        if (a.contains(b)) {
            return a.indexOf(b) == a.length() - b.length();
        }
        else {
            return false;
        }
    }

    public static int boxSeq(int first) { // 2.10
        int result = 0;
        for (int i = 0; i < first; i++) {
            if (i % 2 == 0) {
                result += 3;
            }
            else {
                result -= 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите номер задачи (от 11 до 20):");
        int n = in.nextInt();
        switch (n) {
            case 11:
                Scanner sc = new Scanner(System.in);
                System.out.println("repeat()");
                System.out.println("Введите слово:");
                String a1 = sc.nextLine();
                System.out.println("Введите n:");
                int b1 = in.nextInt();
                System.out.println("Результат: " + repeat(a1, b1));
                break;
            case 12:
                System.out.println("differenceMaxMin()");
                System.out.println("Сколько элементов содержит массив?");
                int a2 = in.nextInt();
                int[] b2 = new int[a2];
                for (int i = 0; i < a2; i++) {
                    System.out.println("Введите " + (i + 1) + " элемент массива:");
                    b2[i] = in.nextInt();
                }
                System.out.println("Результат: " + differenceMaxMin(b2));
                break;
            case 13:
                System.out.println("isAvgWhole()");
                System.out.println("Сколько элементов содержит массив?");
                int a3 = in.nextInt();
                int[] b3 = new int[a3];
                for (int i = 0; i < a3; i++) {
                    System.out.println("Введите " + (i + 1) + " элемент массива:");
                    b3[i] = in.nextInt();
                }
                System.out.println("Результат: " + isAvgWhole(b3));
                break;
            case 14:
                System.out.println("cumulativeSum()");
                System.out.println("Сколько элементов содержит массив?");
                int a4 = in.nextInt();
                int[] b4 = new int[a4];
                for (int i = 0; i < a4; i++) {
                    System.out.println("Введите " + (i + 1) + " элемент массива:");
                    b4[i] = in.nextInt();
                }
                int[] c4 = cumulativeSum(b4);
                System.out.print("Результат:");
                for (int i: c4) {
                    System.out.print(" " + i);
                }
                break;
            case 15:
                Scanner sc2 = new Scanner(System.in);
                System.out.println("getDecimalPlaces()");
                String a5 = sc2.nextLine();
                System.out.println("Результат: " + getDecimalPlaces(a5));
                break;
            case 16:
                System.out.println("Fibonacci()");
                System.out.println("Введите число:");
                int a6 = in.nextInt();
                System.out.println("Результат: " + Fibonacci(a6));
                break;
            case 17:
                Scanner sc3 = new Scanner(System.in);
                System.out.println("isValid()");
                System.out.println("Введите N:");
                String a7 = sc3.nextLine();
                System.out.println("Результат: " + isValid(a7));
                break;
            case 18:
                Scanner sc4 = new Scanner(System.in);
                System.out.println("isStrangePair()");
                System.out.println("Введите первую строку:");
                String a8 = sc4.nextLine();
                System.out.println("Введите вторую строку:");
                String b8 = sc4.nextLine();
                System.out.println("Результат: " + isStrangePair(a8, b8));
                break;
            case 19:
                Scanner sc5 = new Scanner(System.in);
                System.out.println("isPrefix(), isSuffix()");
                System.out.println("Введите строку:");
                String a9 = sc5.nextLine();
                System.out.println("Введите подстроку:");
                String b9 = sc5.nextLine();
                System.out.println("Результат isPrefix(): " + isPrefix(a9, b9));
                System.out.println("Результат isSuffix(): " + isSuffix(a9, b9));
                break;
            case 20:
                System.out.println("boxSeq()");
                System.out.println("Введите число (шаг):");
                int a10 = in.nextInt();
                System.out.println("Результат: " + boxSeq(a10));
                break;
        }
    }
}
