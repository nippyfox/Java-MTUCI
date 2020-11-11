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

    public static String toCamelCase(String a) { // 4.3
        while (a.contains("_")) {
            int find = a.indexOf("_");
            if (find == 0) {
                a = a.substring(1);
            }
            else if (find < a.length() - 2) {
                a = a.substring(0, find) + a.substring(find+1, find + 2).toUpperCase() + a.substring(find + 2);
            }
            else if (find < a.length() - 1) {
                a = a.substring(0, find) + a.substring(find+1, find + 2).toUpperCase();
            }
            else if (find < a.length()) {
                a = a.substring(0, find);
            }
        }
        return a;
    }

    public static String toSnakeCase(String a) {
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) >= 'A' && a.charAt(i) <= 'Z') {
                if (i == 0) {
                    a = a.substring(0, 1).toLowerCase() + a.substring(1);
                }
                else if (i < a.length() - 1) {
                    a = a.substring(0, i) + "_" + a.substring(i, i + 1).toLowerCase() + a.substring(i + 1);
                }
                else {
                    a = a.substring(0, i) + "_" + a.substring(i).toLowerCase();
                }
            }
        }
        return a;
    }

    public static String overTime(float[] array) { // 4.4
        float overtimeMorning = 0.0f, overtime = 0.0f;
        if (array[0] < 9) {
            overtimeMorning = 9.0f - array[0];
        }
        if (array[1] > 17) {
            overtime = (array[1] - 17.0f) + overtimeMorning;
        }
        float result = (array[1] - array[0] - overtime) * array[2] + overtime * array[2] * array[3];
        String res = String.valueOf(result);
        res += "00";
        res = res.substring(0, res.indexOf(".") + 3);
        return "$" + res;
    }

    public static String BMI(String a, String b) { // TODO 4.5
        int weight, height;
        if (a.contains("kilos")) {
            weight = 0;
        }
        else if (a.contains("pounds")) {
            height = 0;
        }
        else {
            return "Некорректный ввод";
        }
        return "0";
    }

    public static int bugger(int a) { // 4.6
        int count = 0;
        while (a >= 10) {
            int mlt = 1, mod;
            while (a != 0) {
                mod = a % 10;
                mlt *= mod;
                a = a / 10;
            }
            a = mlt;
            count++;
        }
        return count;
    }



    public static void main(String[] args) {
        Scanner in = new Scanner(System.in).useLocale(Locale.ENGLISH);
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
                System.out.println("toCamelCase() - 1");
                System.out.println("toSnakeCase() - 2");
                int n3 = in.nextInt();
                if (n3 == 1) {
                    System.out.println("toCamelCase()");
                    String a3 = sc.nextLine();
                    System.out.println("Результат: " + toCamelCase(a3));
                }
                else if (n3 == 2) {
                    System.out.println("toSnakeCase()");
                    String a3 = sc.nextLine();
                    System.out.println("Результат: " + toSnakeCase(a3));
                }
            }
            case 34 -> {
                System.out.println("overTime()");
                float[] a4 = new float[4];
                System.out.println("Введите начало рабочего дня:");
                a4[0] = in.nextFloat();
                System.out.println("Введите конец рабочего дня:");
                a4[1] = in.nextFloat();
                System.out.println("Введите почасовую ставку:");
                a4[2] = in.nextFloat();
                System.out.println("Введите множитель сверхурочных работ:");
                a4[3] = in.nextFloat();
                System.out.println("Результат: " + overTime(a4));
            }
            // TODO 35
            case 36 -> {
                System.out.println("bugger()");
                int a6 = in.nextInt();
                System.out.println("Результат: " + bugger(a6));
            }
        }
    }
}
