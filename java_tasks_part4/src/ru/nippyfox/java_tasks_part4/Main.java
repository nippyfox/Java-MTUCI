package ru.nippyfox.java_tasks_part4;

import java.util.*;
import java.lang.*;

public class Main {

    public static int isSpace(String a, String b) { // 4.1
        String withSpaces = a + " " + b;
        int count = 0;
        for (int i = 0; i < withSpaces.length(); i++) {
            char c = withSpaces.charAt(i);
            if (c == ' ') {
                count++;
            }
        }
        return withSpaces.length() - count;
    }

    public static void essay(int n, int k, String str) {
        String[] arrStr = str.split(" ");
        for (int i = 1; i < n; i++) {
            if (isSpace(arrStr[i-1], arrStr[i]) <= k) {
                arrStr[i] = arrStr[i-1] + " " + arrStr[i];
                arrStr[i-1] = "";
            }
        }
        for (int i = 0; i < n; i++) {
            if (arrStr[i].length() > 0) {
                System.out.println(arrStr[i]);
            }
        }
    }
    
    public static String[] splitBkt(String a) { // 4.2
        boolean checkBkt = true;
        char[] aArray = a.toCharArray();
        String[] resArray = new String[0];
        for (char i : aArray) {
            if (!(i == (int) '(' || i == (int) ')')) {
                checkBkt = false;
                break;
            }
        }
        if (checkBkt) {
            int count0 = 0, count1 = 0, preI = 0;
            for (int i = 0; i < aArray.length-1; i++) {
                if (aArray[i] == '(') count0++;
                if (aArray[i] == ')') count1++;
                if (count0 == count1) {
                    resArray = Arrays.copyOf(resArray, resArray.length + 1);
                    resArray[resArray.length - 1] = a.substring(preI, i+1);
                    preI = i + 1;
                }
            }
            resArray = Arrays.copyOf(resArray, resArray.length + 1);
            resArray[resArray.length - 1] = a.substring(preI);
        }
        return resArray;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите номер задачи (от 31 до 40):");
        int n = in.nextInt();
        switch (n) {
            case 31 -> {
                System.out.println("essay()");
                System.out.println("Введите n:");
                int n1 = in.nextInt();
                System.out.println("Введите k:");
                int k1 = in.nextInt();
                System.out.println("Введите строку:");
                String c1 = sc.nextLine();
                essay(n1, k1, c1);
            }
            case 32 -> {
                System.out.println("split()");
                System.out.println("Введите строку:");
                String a2 = sc.nextLine();
                String[] b2 = splitBkt(a2);
                System.out.println("Результат:");
                for (String s : b2) {
                    System.out.println(s);
                }
            }
            case 33 -> {
                System.out.println("toCamelCase()");
                System.out.println("toSnakeCase()");
            }
        }
    }
}
