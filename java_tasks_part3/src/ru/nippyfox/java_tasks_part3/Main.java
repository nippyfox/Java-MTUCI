package ru.nippyfox.java_tasks_part3;

import java.util.*;
import java.lang.*;

public class Main {

    public static int solutions(int a, int b, int c) { // 3.1
        int i = b * b - 4 * a * c;
        if (i > 0) {
            return 2;
        }
        else if (i == 0) {
            return 1;
        }
        else {
            return 0;
        }
    }

    public static int findZip(String a) { // 3.2
        int c = a.indexOf("zip");
        if (c == -1) {
            return -1;
        }
        else {
            int d = a.indexOf("zip", c + 1);
            return d;
        }
    }

    public static boolean checkPerfect(int n) { // 3.3
        int sum = 0;
        for (int i = 1; i < n; i++){
            if (n % i == 0) {
                sum += i;}
        }
        return sum == n;
    }

    public static String flipEndChars(String a) { // 3.4
        if (a.length() > 1) {
            char firstLetter = a.charAt(0);
            char lastLetter = a.charAt(a.length()-1);
            if (firstLetter == lastLetter) {
                return "Два - это пара.";
            }
            else {
                String restLine = a.substring(1, a.length()-1);
                return String.valueOf(lastLetter) + restLine + String.valueOf(firstLetter);
            }
        }
        else {
            return "Несовместимо.";
        }
    }

    public static boolean isValidHexCode(String a) { // 3.5
        boolean checking = true;
        if (a.length() == 7 && a.charAt(0) == '#') {
            for (int i = 1; i < 7; i++) {
                if (!((a.charAt(i) >= '0' && a.charAt(i) <= '9') || (a.charAt(i) >= 'A' && a.charAt(i) <= 'F') || (a.charAt(i) >= 'a' && a.charAt(i) <= 'f'))) {
                    checking = false;
                    break;
                }
            }
            return checking;
        }
        else {
            return false;
        }
    }

    public static boolean same(int[] arr1, int[] arr2) { // 3.6
        Random random = new Random();
        int k = 0;
        int c = 0;
        boolean exitWhile = false; // Creating random number with which we will remove repetitions from an array
        int notInArray = 0;
        while (!exitWhile) {
            boolean exitCycle = true;
            notInArray = random.nextInt();
            for (int i : arr1) {
                if (notInArray == i) {
                    exitCycle = false;
                    break;
                }
            }
            for (int i : arr2) {
                if (notInArray == i) {
                    exitCycle = false;
                    break;
                }
            }
            if (exitCycle) {
                exitWhile = true;
            }
        }
        for (int i = 0; i < arr1.length; i++){ // Replace repeating numbers in first array
            for (int j = 0; j < arr1.length; j++) {
                if (arr1[i] == arr1[j] && i != j) {
                    arr1[j] = notInArray;
                }
            }
        }
        for (int i : arr1) { // Finding unique numbers in first array
            if (i != notInArray) {
                k += 1;
            }
        }
        for (int i = 0; i < arr2.length; i++) { // Replace repeating numbers in second array
            for (int j = 1; j < arr2.length; j++) {
                if (arr2[i] == arr2[j] && i != j) {
                    arr2[j] = notInArray;
                }
            }
        }
        for (int i : arr2) { // Finding unique numbers in second array
            if (i != notInArray) {
                c += 1;
            }
        }
        return c == k;
    }

    public static boolean isKaprekar(int a) { // 3.7
        int sec = a * a;
        String strSqrt = String.valueOf(sec);
        String strFirst = strSqrt.substring(0, strSqrt.length() / 2);
        String strSec = strSqrt.substring(strSqrt.length() / 2);
        if (strFirst.length() == 0) {
            int intSec = Integer.parseInt(strSec);
            return intSec == a;
        }
        else {
            int intFirst = Integer.parseInt(strFirst);
            int intSec = Integer.parseInt(strSec);
            return intFirst + intSec == a;
        }
    }
    
    public static String longestZero(String a) { // 3.8
        boolean checkNumbers = true;
        char[] aArray = a.toCharArray();
        for (char i : aArray) {
            if (!(i == (int) '0' || i == (int) '1')) {
                checkNumbers = false;
                break;
            }
        }
        if (!checkNumbers) {
            return "В строке содержатся другие символы, помимо 0 и 1";
        }
        else {
            int x = Integer.parseInt(a,2);
            long count = 0, maxZero = 0;
            while (x > 0) {
                if ((x & 1) == 1) {
                    if (count > maxZero) {
                        maxZero = count;
                    }
                    count = 0;
                }
                else {
                    count += 1;
                }
                x = x >> 1;
            }
            String result = "";
            for (int i = 0; i < maxZero; i++) {
                result += "0";
            }
            return result;
        }
    }

    public static boolean isPrime(int n) { // 3.9
        boolean result = true;
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                result = false;
                break;
            }
        }
        return result;
    }

    public static int nextPrime(int a) {
        while (true) {
            if (isPrime(a)) {
                return a;
            }
            a++;
        }
    }

    public static boolean rightTriangle(int a, int b, int c) { // 3.10
        int maxValue = 0;
        int firstValue = 0;
        int secondValue = 0;
        if (a > b && a > c) {
            maxValue = a;
            firstValue = b;
            secondValue = c;
        }
        else if (b > a && b > c) {
            maxValue = b;
            firstValue = a;
            secondValue = c;
        }
        else if (c > a && c > b) {
            maxValue = c;
            firstValue = a;
            secondValue = b;
        }
        else {
            return false;
        }
        return maxValue * maxValue == firstValue * firstValue + secondValue * secondValue;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите номер задачи (от 21 до 30):");
        int n = in.nextInt();
        switch (n) {
            case 21 -> {
                System.out.println("solutions()");
                System.out.println("Введите a:");
                int a1 = in.nextInt();
                System.out.println("Введите b:");
                int b1 = in.nextInt();
                System.out.println("Введите c:");
                int c1 = in.nextInt();
                System.out.println("Результат: " + solutions(a1, b1, c1));
            }
            case 22 -> {
                Scanner sc = new Scanner(System.in);
                System.out.println("findZip()");
                System.out.println("Введите строку:");
                String a2 = sc.nextLine();
                System.out.println("Результат: " + findZip(a2));
            }
            case 23 -> {
                System.out.println("checkPerfect()");
                System.out.println("Введите целое число:");
                int a3 = in.nextInt();
                System.out.println("Результат: " + checkPerfect(a3));
            }
            case 24 -> {
                Scanner sc2 = new Scanner(System.in);
                System.out.println("flipEndChars()");
                System.out.println("Введите строку:");
                String a4 = sc2.nextLine();
                System.out.println("Результат: " + flipEndChars(a4));
            }
            case 25 -> {
                Scanner sc3 = new Scanner(System.in);
                System.out.println("isValidHexCode()");
                System.out.println("Введите строку:");
                String a5 = sc3.nextLine();
                System.out.println("Результат: " + isValidHexCode(a5));
            }
            case 26 -> {
                System.out.println("same()");
                System.out.println("Сколько элементов будет в первом массиве?");
                int n6 = in.nextInt();
                int[] array6 = new int[n6];
                for (int i = 0; i < n6; i++) {
                    System.out.println("Введите " + i + " элемент массива:");
                    array6[i] = in.nextInt();
                }
                System.out.println("Сколько элементов будет во втором массиве?");
                int n62 = in.nextInt();
                int[] array62 = new int[n62];
                for (int i = 0; i < n62; i++) {
                    System.out.println("Введите " + i + " элемент массива:");
                    array62[i] = in.nextInt();
                }
                System.out.println("Результат: " + same(array6, array62));
            }
            case 27 -> {
                System.out.println("isKaprekar()");
                int n7 = in.nextInt();
                System.out.println("Результат: " + isKaprekar(n7));
            }
            case 28 -> {
                Scanner sc4 = new Scanner(System.in);
                System.out.println("longestZero()");
                String a8 = sc4.nextLine();
                System.out.println("Результат: " + longestZero(a8));
            }
            case 29 -> {
                System.out.println("nextPrime()");
                int n9 = in.nextInt();
                System.out.println("Результат: " + nextPrime(n9));
            }
            case 30 -> {
                System.out.println("rightTriangle()");
                System.out.println("Введите a:");
                int a10 = in.nextInt();
                System.out.println("Введите b:");
                int b10 = in.nextInt();
                System.out.println("Введите c:");
                int c10 = in.nextInt();
                System.out.println("Результат: " + rightTriangle(a10, b10, c10));
            }
        }
    }
}
